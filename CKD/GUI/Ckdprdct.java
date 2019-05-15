

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Random;
import java.util.stream.IntStream;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


class temp3{
	double c1,c2,c3,c4,c5,c6,c7,c8,c9,c10,z;
}
/**
 * Servlet implementation class ckdpredict
 */
@WebServlet("/Ckdprdct")
public class Ckdprdct extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Ckdprdct() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest requestuest, HttpServletResponse responseonse)
	 */
	protected void doGet(HttpServletRequest requestuest, HttpServletResponse responseonse) throws ServletException, IOException {
		// TODO Auto-generated method stub
		responseonse.getWriter().append("Served at: ").append(requestuest.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest requestuest, HttpServletResponse responseonse)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br=new BufferedReader(new FileReader(new File("C:\\Users\\aprad\\eclipse-workspace\\ckd_prediction\\Data_chronic_kidney_disease_updated.csv")));
		String data=br.readLine();
		double weight[]=new double[11];
		Random rand=new Random();

		
		data=br.readLine();
		
		ArrayList<temp3> al=new ArrayList<>();
		while(data!=null) {
			String[] dataarr=data.split(",");
			temp3 v=new temp3();
			v.c1=Double.parseDouble(dataarr[1]);
			v.c2=Double.parseDouble(dataarr[2]);
			v.c3=Double.parseDouble(dataarr[3]);
			v.c4=Double.parseDouble(dataarr[4]);
			v.c5=Double.parseDouble(dataarr[5]);
			v.c6=Double.parseDouble(dataarr[6]);
			v.c7=Double.parseDouble(dataarr[7]);
			v.c8=Double.parseDouble(dataarr[8]);
			v.c9=Double.parseDouble(dataarr[9]);
			v.c10=Double.parseDouble(dataarr[10]);
			al.add(v);
			data=br.readLine();
		}
		weight[0]=rand.nextInt(327672*2)-32767;
		weight[1]=rand.nextInt(327672*2)-32767;
		weight[2]=rand.nextInt(327672*2)-32767;
		weight[3]=rand.nextInt(327672*2)-32767;
		weight[4]=rand.nextInt(327672*2)-32767;
		weight[5]=rand.nextInt(327672*2)-32767;
		weight[6]=rand.nextInt(327672*2)-32767;
		weight[7]=rand.nextInt(327672*2)-32767;
		weight[8]=rand.nextInt(327672*2)-32767;
		weight[9]=rand.nextInt(327672*2)-32767;
		weight[10]=rand.nextInt(327672*2)-32767;
		
		double[] err = {0};
		double rate= 0.02;
		double[] sum= {0};
		long st=System.currentTimeMillis();
		IntStream.range(0, 100000).parallel().forEach(i -> {
			  IntStream.range(1, al.size()-1).parallel().forEach(j -> {
				    
				  
				int res=0;
				
				sum[0]=weight[0]+weight[1]*(al.get(j)).c1+weight[2]*(al.get(j)).c2+weight[3]*(al.get(j)).c3+weight[4]*(al.get(j)).c4+weight[5]*(al.get(j)).c5
					+weight[6]*(al.get(j)).c6+weight[7]*(al.get(j)).c7+weight[8]*(al.get(j)).c8+weight[9]*(al.get(j)).c9
					+weight[10]*(al.get(j)).c10;
				
				if(sum[0]>0)
					res=1;
				err[0]=(al.get(j)).z-res;
				weight[0]=weight[0]+(err[0])*rate;
				weight[1]=weight[1]+(err[0]*rate*(al.get(j)).c1);
				weight[2]=weight[2]+(err[0]*rate*(al.get(j)).c2);
				weight[3]=weight[2]+(err[0]*rate*(al.get(j)).c3);
				weight[4]=weight[2]+(err[0]*rate*(al.get(j)).c4);
				weight[5]=weight[2]+(err[0]*rate*(al.get(j)).c5);
				weight[6]=weight[2]+(err[0]*rate*(al.get(j)).c6);
				weight[7]=weight[2]+(err[0]*rate*(al.get(j)).c7);
				weight[8]=weight[2]+(err[0]*rate*(al.get(j)).c8);
				weight[9]=weight[2]+(err[0]*rate*(al.get(j)).c9);
				weight[10]=weight[2]+(err[0]*rate*(al.get(j)).c10);
			  });
		});
		long et=System.currentTimeMillis();
		System.out.println("Time:"+(et-st)+"ms");
		int res;
		
		double b1= Double.parseDouble(request.getParameter("sg"));
		double b2= Double.parseDouble(request.getParameter("ab"));
		
		String map= request.getParameter("pc");
		if(map.equals("normal")) res=1; else res=0;
		double b3=res;
		
		double b4= Double.parseDouble(request.getParameter("hg"));
		
		double b5= Double.parseDouble(request.getParameter("pcv"));
		
		double b6= Double.parseDouble(request.getParameter("rbc"));
		
		map= request.getParameter("ht");
		if(map.equals("Yes")) res=1; else res=0;
		double b7=res;
		
		map= request.getParameter("dm");
		if(map.equals("Yes")) res=1; else res=0;
		double b8=res;
		
		map= request.getParameter("ap");
		if(map.equals("Good")) res=1; else res=0;
		double b9=res;
		
		map= request.getParameter("pe");
		if(map.equals("Yes")) res=1; else res=0;
		double b10=res;
		
		double sum1;
		sum1=weight[0]+weight[1]*b1+weight[2]*b2+weight[3]*b3+weight[4]*b4+weight[5]*b5+weight[6]*b6
				+weight[7]*b7+weight[8]*b8+weight[9]*b9+weight[10]*b10;
		
		//PrintWriter pw=response.getWriter();
		//if(sum1>0)
			//pw.println("The patient is prone to Chronic Kidney Disease");
		//else
			//pw.println("The patient is NOT prone to Chronic Kidney Disease");
	
		//pw.close();
		br.close();
		
		if(sum1>0) request.setAttribute("res", "NCKD");
		else request.setAttribute("res", "CKD");
			
			
		if(b1<1.0) request.setAttribute("sg", "0");
		else if(b1==1.025) request.setAttribute("sg", "1");
		else request.setAttribute("sg", "2");
		
		if(b2<0) request.setAttribute("al", "0");
		else if(b2==0) request.setAttribute("al", "1");
		else request.setAttribute("al", "2");
		
		if(b4<12) request.setAttribute("hg", "0");
		else if(b4>=12 && b4<=16) request.setAttribute("hg", "1");
		else request.setAttribute("hg", "2");
		
		if(b5<43) request.setAttribute("pcv", "0");
		else if(b5>=43 && b5<=51) request.setAttribute("pcv", "1");
		else request.setAttribute("pcv", "2");
		
		if(b6<4.5) request.setAttribute("rbc", "0");
		else if(b6>=4.5 && b6<=6) request.setAttribute("rbc", "1");
		else request.setAttribute("rbc", "2");
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("result.jsp");
		dispatcher.forward(request, response);
	
	}

}
