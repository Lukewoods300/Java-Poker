package poker;
import java.net.*;
import java.io.*;

public class Client 
{
	public static void main(String[] args) throws IOException
	{/*
		Socket s = new Socket("localhost", 4999);
		
		PrintWriter pr = new PrintWriter(s.getOutputStream());
		pr.println("it is working");
		pr.flush();
		
		InputStreamReader in = new InputStreamReader(s.getInputStream());
		BufferedReader bf = new BufferedReader(in);
		
		String str = bf.readLine();
		System.out.println("server : " + str);
		*/
		Client a = new Client();
	}
	
	public Client() throws IOException{
		
	}
	
	public boolean joinServer() throws IOException{
		try {
			Socket s = new Socket("localhost", 4999);
			
			PrintWriter pr = new PrintWriter(s.getOutputStream());
			pr.println("it is working");
			pr.flush();
			
			InputStreamReader in = new InputStreamReader(s.getInputStream());
			BufferedReader bf = new BufferedReader(in);
			
			String str = bf.readLine();
			System.out.println("server : " + str);
			}
			catch(ConnectException e){
				return false;
			}
		return true;
	}
}