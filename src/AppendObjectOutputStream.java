

import java.io.*;

public class AppendObjectOutputStream extends ObjectOutputStream
{
   // constructor
   public AppendObjectOutputStream( OutputStream out ) throws IOException
   {
      // this constructor just calls the super (parent)
      super(out);
   }

   @Override
   protected void writeStreamHeader() throws IOException
   {
      // this forces Java to clear the previous header, re-write a new header,
      // and prevents file corruption
      reset();
   }
}