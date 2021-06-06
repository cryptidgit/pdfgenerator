package mypack;

import com.itextpdf.*;

public class PDF {
	private String name, dest;
	
	private void setName(String name) {
		this.name = name + ".pdf";
	}
	
	private void setDest(String dest) {
		if(!name.isEmpty()) {
			this.dest = dest;
		} else {
			this.dest = dest + "/" + name;
		}
	}
	
}
