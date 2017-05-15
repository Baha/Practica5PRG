import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class TestPractica5PRG.
 *
 * @author  Adrian Palacios
 * @version 1.0
 */
public class TestPractica5PRG
{
    /**
     * Default constructor for test class TestPractica5PRG
     */
    public TestPractica5PRG()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }
    
    @Test
    public void test_talla() {
        ConjuntString conjunt = new ConjuntString();
        int talla;
        
        talla = conjunt.talla();
        assertEquals(0,talla);
        
        conjunt.inserir("i");
        talla = conjunt.talla();
        assertEquals(1,talla);
            
        conjunt.inserir("a");
        talla = conjunt.talla();
        assertEquals(2,talla);
            
        conjunt.inserir("u");
        talla = conjunt.talla();
        assertEquals(3,talla);
            
        conjunt.inserir("e");
        talla = conjunt.talla();
        assertEquals(4,talla);
            
        conjunt.inserir("o");
        talla = conjunt.talla();
        assertEquals(5,talla);

        conjunt.inserir("u");
        talla = conjunt.talla();
        assertEquals(5,talla);
    }
    
    @Test
    public void test_inserir() {
        ConjuntString conjunt = new ConjuntString();
        String res;
        
        conjunt.inserir("i");
        res = conjunt.toString();
        assertEquals("i\n",res);
            
        conjunt.inserir("a");
        res = conjunt.toString();
        assertEquals("a\ni\n",res);
            
        conjunt.inserir("u");
        res = conjunt.toString();
        assertEquals("a\ni\nu\n",res);
            
        conjunt.inserir("e");
        res = conjunt.toString();
        assertEquals("a\ne\ni\nu\n",res);
            
        conjunt.inserir("o");
        res = conjunt.toString();
        assertEquals("a\ne\ni\no\nu\n",res);

        conjunt.inserir("u");
        res = conjunt.toString();
        assertEquals("a\ne\ni\no\nu\n",res);
    }
    
    @Test
    public void test_pertany() {
        ConjuntString conjunt = new ConjuntString();
        boolean res;
        
        res = conjunt.pertany("u");
        assertEquals(false,res);
        
        conjunt.inserir("a");
        conjunt.inserir("e");
        conjunt.inserir("i");
        
        res = conjunt.pertany("a");
        assertEquals(true,res);
        res = conjunt.pertany("e");
        assertEquals(true,res);
        res = conjunt.pertany("i");
        assertEquals(true,res);
        res = conjunt.pertany("o");
        assertEquals(false,res);
    }
    
    @Test
    public void test_eliminar() {
        ConjuntString conjunt = new ConjuntString();
        String res;
        
        conjunt.eliminar("u");
        res = conjunt.toString();
        assertEquals("",res);
        
        conjunt.inserir("i");
        conjunt.inserir("a");
        conjunt.inserir("u");
        conjunt.inserir("e");
        conjunt.inserir("o");
        
        res = conjunt.toString();
        assertEquals("a\ne\ni\no\nu\n",res);
        
        conjunt.eliminar("z");
        res = conjunt.toString();
        assertEquals("a\ne\ni\no\nu\n",res);
        
        conjunt.eliminar("o");
        res = conjunt.toString();
        assertEquals("a\ne\ni\nu\n",res);
        
        conjunt.eliminar("e");
        res = conjunt.toString();
        assertEquals("a\ni\nu\n",res);
            
        conjunt.eliminar("u");
        res = conjunt.toString();
        assertEquals("a\ni\n",res);
            
        conjunt.eliminar("a");
        res = conjunt.toString();
        assertEquals("i\n",res);
            
        conjunt.eliminar("i");
        res = conjunt.toString();
        assertEquals("",res);

        conjunt.eliminar("i");
        res = conjunt.toString();
        assertEquals("",res);    
    }
    
    @Test
    public void test_interseccio() {
        ConjuntString c1 = new ConjuntString();
        ConjuntString c2 = new ConjuntString();
        ConjuntString cres;
        String res;
        
        c1.inserir("a");
        c1.inserir("c");
        c1.inserir("e");
        
        cres = c1.interseccio(c2);
        res = cres.toString();
        assertEquals("",res);
        
        c2.inserir("o");
        c2.inserir("p");
        c2.inserir("q");
        
        cres = c2.interseccio(c1);
        res = cres.toString();
        assertEquals("",res);
        
        c1.inserir("d");
        c1.inserir("f");
        c1.inserir("o");
        c2.inserir("d");
        c2.inserir("f");
        
        cres = c1.interseccio(c2);
        res = cres.toString();
        assertEquals("d\nf\no\n",res);
        
        cres = c1.interseccio(c1);
        res = cres.toString();
        assertEquals("a\nc\nd\ne\nf\no\n",res);       
    }
    
        @Test
    public void test_unio() {
        ConjuntString c1 = new ConjuntString();
        ConjuntString c2 = new ConjuntString();
        ConjuntString cres;
        String res;
        
        c1.inserir("a");
        c1.inserir("c");
        c1.inserir("e");
        
        cres = c1.unio(c2);
        res = cres.toString();
        assertEquals("a\nc\ne\n",res);
        
        c2.inserir("o");
        c2.inserir("p");
        c2.inserir("q");
        
        cres = c2.unio(c1);
        res = cres.toString();
        assertEquals("a\nc\ne\no\np\nq\n",res);
        
        c1.inserir("d");
        c1.inserir("f");
        c1.inserir("o");
        c2.inserir("d");
        c2.inserir("f");
        
        cres = c1.unio(c2);
        res = cres.toString();
        assertEquals("a\nc\nd\ne\nf\no\np\nq\n",res);
        
        cres = c1.unio(c1);
        res = cres.toString();
        assertEquals(c1.toString(),res);       
    }
}
