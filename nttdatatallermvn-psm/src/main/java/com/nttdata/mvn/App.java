package com.nttdata.mvn;
import org.apache.commons.lang3.arch.Processor;
import org.apache.commons.lang3.arch.Processor.Arch;
import org.apache.commons.lang3.arch.Processor.Type;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        Processor procesador = new Processor(Arch.BIT_32,Type.IA_64);
        System.out.println(procesador);
        System.out.println(procesador.getArch());
        System.out.println(App.random());
    }
    
    private static double random() {
    	return Math.random();
    }
}
