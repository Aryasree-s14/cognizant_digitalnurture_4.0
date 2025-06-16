package builder;

public class Computer {
	private String cpu,ram,storage;
	private Computer(Builder b)
	{
		 this.cpu = b.cpu;
	     this.ram = b.ram;
	     this.storage = b.storage;
	     
	}
	 public void specifications() {
	        System.out.println("CPU: " + cpu + ", RAM: " + ram + ", Storage: " + storage );
	    }
	 public static class Builder {
	        private String cpu, ram, storage;

	        public Builder cpu(String c)
	        { 
	        	this.cpu = c; 
	        	return this;
	        }
	        public Builder ram(String r)
	        {
	        	this.ram = r; 
	        	return this; 
	        }
	        public Builder storage(String s)
	        {
	        	this.storage = s; 
	            return this; 
	        }
	        

	        public Computer build() 
	        {
	            return new Computer(this);
	        }
	    }
	}


