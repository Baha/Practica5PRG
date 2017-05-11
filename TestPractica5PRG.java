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
        ConjuntoString conjunto = new ConjuntoString();
        int talla;
        
        talla = conjunto.talla();
        assertEquals(0,talla);
        
        conjunto.insertar("i");
        talla = conjunto.talla();
        assertEquals(1,talla);
            
        conjunto.insertar("a");
        talla = conjunto.talla();
        assertEquals(2,talla);
            
        conjunto.insertar("u");
        talla = conjunto.talla();
        assertEquals(3,talla);
            
        conjunto.insertar("e");
        talla = conjunto.talla();
        assertEquals(4,talla);
            
        conjunto.insertar("o");
        talla = conjunto.talla();
        assertEquals(5,talla);

        conjunto.insertar("u");
        talla = conjunto.talla();
        assertEquals(5,talla);
    }
    
    @Test
    public void test_insertar() {
        ConjuntoString conjunto = new ConjuntoString();
        String res;
        
        conjunto.insertar("i");
        res = conjunto.toString();
        assertEquals("i\n",res);
            
        conjunto.insertar("a");
        res = conjunto.toString();
        assertEquals("a\ni\n",res);
            
        conjunto.insertar("u");
        res = conjunto.toString();
        assertEquals("a\ni\nu\n",res);
            
        conjunto.insertar("e");
        res = conjunto.toString();
        assertEquals("a\ne\ni\nu\n",res);
            
        conjunto.insertar("o");
        res = conjunto.toString();
        assertEquals("a\ne\ni\no\nu\n",res);

        conjunto.insertar("u");
        res = conjunto.toString();
        assertEquals("a\ne\ni\no\nu\n",res);
    }
    
    @Test
    public void test_pertenece() {
        ConjuntoString conjunto = new ConjuntoString();
        boolean res;
        
        res = conjunto.pertenece("u");
        assertEquals(false,res);
        
        conjunto.insertar("a");
        conjunto.insertar("e");
        conjunto.insertar("i");
        
        res = conjunto.pertenece("a");
        assertEquals(true,res);
        res = conjunto.pertenece("e");
        assertEquals(true,res);
        res = conjunto.pertenece("i");
        assertEquals(true,res);
        res = conjunto.pertenece("o");
        assertEquals(false,res);
    }
    
    @Test
    public void test_eliminar() {
        ConjuntoString conjunto = new ConjuntoString();
        String res;
        
        conjunto.eliminar("u");
        res = conjunto.toString();
        assertEquals("",res);
        
        conjunto.insertar("i");
        conjunto.insertar("a");
        conjunto.insertar("u");
        conjunto.insertar("e");
        conjunto.insertar("o");
        
        res = conjunto.toString();
        assertEquals("a\ne\ni\no\nu\n",res);
        
        conjunto.eliminar("z");
        res = conjunto.toString();
        assertEquals("a\ne\ni\no\nu\n",res);
        
        conjunto.eliminar("o");
        res = conjunto.toString();
        assertEquals("a\ne\ni\nu\n",res);
        
        conjunto.eliminar("e");
        res = conjunto.toString();
        assertEquals("a\ni\nu\n",res);
            
        conjunto.eliminar("u");
        res = conjunto.toString();
        assertEquals("a\ni\n",res);
            
        conjunto.eliminar("a");
        res = conjunto.toString();
        assertEquals("i\n",res);
            
        conjunto.eliminar("i");
        res = conjunto.toString();
        assertEquals("",res);

        conjunto.eliminar("i");
        res = conjunto.toString();
        assertEquals("",res);    
    }
    
    @Test
    public void test_interseccion() {
        ConjuntoString c1 = new ConjuntoString();
        ConjuntoString c2 = new ConjuntoString();
        ConjuntoString cres;
        String res;
        
        c1.insertar("a");
        c1.insertar("c");
        c1.insertar("e");
        
        cres = c1.interseccion(c2);
        res = cres.toString();
        assertEquals("",res);
        
        c2.insertar("o");
        c2.insertar("p");
        c2.insertar("q");
        
        cres = c2.interseccion(c1);
        res = cres.toString();
        assertEquals("",res);
        
        c1.insertar("d");
        c1.insertar("f");
        c1.insertar("o");
        c2.insertar("d");
        c2.insertar("f");
        
        cres = c1.interseccion(c2);
        res = cres.toString();
        assertEquals("d\nf\no\n",res);
        
        cres = c1.interseccion(c1);
        res = cres.toString();
        assertEquals("a\nc\nd\ne\nf\no\n",res);       
    }
    
        @Test
    public void test_union() {
        ConjuntoString c1 = new ConjuntoString();
        ConjuntoString c2 = new ConjuntoString();
        ConjuntoString cres;
        String res;
        
        c1.insertar("a");
        c1.insertar("c");
        c1.insertar("e");
        
        cres = c1.union(c2);
        res = cres.toString();
        assertEquals("a\nc\ne\n",res);
        
        c2.insertar("o");
        c2.insertar("p");
        c2.insertar("q");
        
        cres = c2.union(c1);
        res = cres.toString();
        assertEquals("a\nc\ne\no\np\nq\n",res);
        
        c1.insertar("d");
        c1.insertar("f");
        c1.insertar("o");
        c2.insertar("d");
        c2.insertar("f");
        
        cres = c1.union(c2);
        res = cres.toString();
        assertEquals("a\nc\nd\ne\nf\no\np\nq\n",res);
        
        cres = c1.union(c1);
        res = cres.toString();
        assertEquals(c1.toString(),res);       
    }
}
