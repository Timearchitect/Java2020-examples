package svgTestDisplay;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;
import java.util.*;

import javax.imageio.ImageIO;
import javax.imageio.ImageTranscoder;
import javax.imageio.ImageTypeSpecifier;
import javax.imageio.ImageWriteParam;
import javax.imageio.metadata.IIOMetadata;
import javax.imageio.spi.ImageTranscoderSpi;

import org.apache.batik.transcoder.TranscoderException;
import org.apache.batik.transcoder.TranscoderInput;
import org.apache.batik.transcoder.TranscoderOutput;
import org.apache.batik.transcoder.TranscodingHints.Key;
import org.apache.batik.transcoder.image.JPEGTranscoder;
import org.apache.batik.transcoder.image.PNGTranscoder;

public class SVG {

	public static void main(String[] args) {
		//String url= "https://upload.wikimedia.org/wikipedia/commons/b/b6/Compass_360_%28en%29.svg";
		
		String path="src/Compass_360_(en).svg";

		 // Create a JPEG transcoder
	    JPEGTranscoder t = new JPEGTranscoder();

	    // Set the transcoding hints.
	    t.addTranscodingHint(JPEGTranscoder.KEY_QUALITY, new Float(.8));

	    // Create the transcoder input.
	    String svgURI = new File(path).toURI().toString();
	    TranscoderInput input = new TranscoderInput(svgURI);

	    // Create the transcoder output.
	    OutputStream ostream;
	    
		try {
			ostream = new FileOutputStream("icon.jpg");
			   TranscoderOutput output = new TranscoderOutput(ostream);
			    // Save the image.
			    t.transcode(input, output);
			    // Flush and close the stream.
			    ostream.flush();
			    ostream.close();
			    System.out.println("!!!success!!! export");
		} catch (IOException | TranscoderException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
