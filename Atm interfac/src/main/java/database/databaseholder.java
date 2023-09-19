package database;

import java.lang.System.Logger;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.logging.Level;






public class databaseholder {
	 private String url;
	    private String Username;
	    private String Password;
	    private Connection con ;
	    public databaseholder(){
	        try {
	        	Class.forName("com.mysql.cj.jdbc.Driver");
	            url= "jdbc:mysql://localhost:3306/atm";
	            Username = "root";
	            Password = "vivek1201@";
	            try {
	                con = DriverManager.getConnection(url,Username,Password);
	            } catch (SQLException ex) {
	            	ex.printStackTrace();
	            }
	        } catch (ClassNotFoundException ex) {
	        	ex.printStackTrace();
	        }
	    }
	   
	    public long ins(String name,String mail,long phone,int age,long card,int pin)
	    {
	        long ans= 0;
	        String sql="insert into vivek (name,mail,phone,age,card,pin) value('"+name+"','"+mail+"','"+phone+"','"+age+"','"+card+"','"+pin+"')";
	        Statement st;
	        try {
	            st = con.createStatement();
	            st.execute(sql);
	            ans=1;
	            return ans;
	        } catch (SQLException ex) {
	        	ex.printStackTrace();// Logger.getLogger(dbholder.class.getName()).log(Level.SEVERE, null, ex);
	        }
	        return ans;
	    }
	    

	   
	    public int chcekCardNumber(long num)
	    {
	        int flag = 0;
	        String Sql = "SELECT card FROM vivek WHERE card= "+num+"";
	        Statement st;
	        try {
	            st =  con.createStatement();
	            ResultSet rs=st.executeQuery(Sql);
	            if(rs.isBeforeFirst())
	            {
	                flag = 1;
	            }
	        } catch (SQLException ex) {
	        	ex.printStackTrace();
	            
	        }
	        
	        return flag;
	    }
	    public int checkPin(long num)
	    {
	        int pin=108;
	        
	        
	        String Sql = "SELECT pin FROM vivek WHERE card= "+num+"";  
	        try {
	            Statement st = con.createStatement();
	            ResultSet rs = st.executeQuery(Sql);
	            
	            if(rs.next())
	            {
	                pin = rs.getInt(1);
	            }
	        } catch (SQLException ex) {
	        	ex.printStackTrace();
	           // Logger.getLogger(databaseholder.class.getName()).log(Level.SEVERE, null, ex);
	        }
	        return pin;
	    }
	    public int getValue(String getter,long num)
	    {
	        int flag = 0;
	        String Sql = "SELECT "+getter+" FROM vivek WHERE card= "+num+"";
	        try {
	            Statement st = con.createStatement();
	            ResultSet rs = st.executeQuery(Sql);
	            if(rs.next())
	            {
	                flag = rs.getInt(1);
	            }
	        } catch (SQLException ex) {
	        	ex.printStackTrace(); 
	        	//Logger.getLogger(db_holder.class.getName()).log(Level.SEVERE, null, ex);
	        }
	        return flag;  
	    }
	    
	public    int pinchange(int pin ,long num) {
		int flag=0;
		String Sql ="UPDATE vivek SET pin ="+pin+" where card="+num+"";
		
		Statement st;
        try {
            st = con.createStatement();
            st.executeUpdate(Sql);
            flag = 1;
        } catch (SQLException ex) {
        	ex.printStackTrace();
        }
        return flag;
    }
	    	
	    

	    public int setValue(String setField,int setFieldValue,long card)
	    {
	        int flag = 0;
	        String Sql = "UPDATE vivek SET "+setField+" ="+setFieldValue+" WHERE card= "+card+"";  
	        Statement st;
	        try {
	            st = con.createStatement();
	            st.executeUpdate(Sql);
	            flag = 1;
	        } catch (SQLException ex) {
	        	ex.printStackTrace();
	        }
	        return flag;
	    }
	    public long cardno(long num)
	    {
	       
	       return num;  
	    }


	    public int trans_ins(String type,int amount, long card)
	    {  
	    	LocalDateTime date= LocalDateTime.now(); 
	        int flag = 0;
	        String sql="insert into transection(amount,type,card,date) values('"+amount+"','"+type+"','"+card+"','"+date+"')";
	        Statement st;
	        try {
	            st = con.createStatement();
	            st.execute(sql);
	            flag += 1;
	        } catch (SQLException ex) {
	        	ex.printStackTrace();// Logger.getLogger(databaseholder.class.getName()).log(Level.SEVERE, null, ex);
	        } 
	        return flag;
	    }
	        public ResultSet loadMiniStatement(long card)
	        {
	            ResultSet rs = null;
	            String Sql = "SELECT * FROM transection WHERE card= "+card+" ORDER BY date DESC";
	            try {
	                Statement st = con.createStatement();
	                rs = st.executeQuery(Sql);
	            } catch (SQLException ex) {
	            	ex.printStackTrace();// Logger.getLogger(db_holder.class.getName()).log(Level.SEVERE, null, ex);
	            }
	            return rs;
	        }

	    
	    } 
		


