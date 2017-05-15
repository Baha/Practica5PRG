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
    public void test_size() {
        StringSet set = new StringSet();
        int size;
        
        size = set.size();
        assertEquals(0,size);
        
        set.add("i");
        size = set.size();
        assertEquals(1,size);
            
        set.add("a");
        size = set.size();
        assertEquals(2,size);
            
        set.add("u");
        size = set.size();
        assertEquals(3,size);
            
        set.add("e");
        size = set.size();
        assertEquals(4,size);
            
        set.add("o");
        size = set.size();
        assertEquals(5,size);

        set.add("u");
        size = set.size();
        assertEquals(5,size);
    }
    
    @Test
    public void test_add() {
        StringSet set = new StringSet();
        String res;
        
        set.add("i");
        res = set.toString();
        assertEquals("i\n",res);
            
        set.add("a");
        res = set.toString();
        assertEquals("a\ni\n",res);
            
        set.add("u");
        res = set.toString();
        assertEquals("a\ni\nu\n",res);
            
        set.add("e");
        res = set.toString();
        assertEquals("a\ne\ni\nu\n",res);
            
        set.add("o");
        res = set.toString();
        assertEquals("a\ne\ni\no\nu\n",res);

        set.add("u");
        res = set.toString();
        assertEquals("a\ne\ni\no\nu\n",res);
    }
    
    @Test
    public void test_belongsTo() {
        StringSet set = new StringSet();
        boolean res;
        
        res = set.belongsTo("u");
        assertEquals(false,res);
        
        set.add("a");
        set.add("e");
        set.add("i");
        
        res = set.belongsTo("a");
        assertEquals(true,res);
        res = set.belongsTo("e");
        assertEquals(true,res);
        res = set.belongsTo("i");
        assertEquals(true,res);
        res = set.belongsTo("o");
        assertEquals(false,res);
    }
    
    @Test
    public void test_remove() {
        StringSet set = new StringSet();
        String res;
        
        set.remove("u");
        res = set.toString();
        assertEquals("",res);
        
        set.add("i");
        set.add("a");
        set.add("u");
        set.add("e");
        set.add("o");
        
        res = set.toString();
        assertEquals("a\ne\ni\no\nu\n",res);
        
        set.remove("z");
        res = set.toString();
        assertEquals("a\ne\ni\no\nu\n",res);
        
        set.remove("o");
        res = set.toString();
        assertEquals("a\ne\ni\nu\n",res);
        
        set.remove("e");
        res = set.toString();
        assertEquals("a\ni\nu\n",res);
            
        set.remove("u");
        res = set.toString();
        assertEquals("a\ni\n",res);
            
        set.remove("a");
        res = set.toString();
        assertEquals("i\n",res);
            
        set.remove("i");
        res = set.toString();
        assertEquals("",res);

        set.remove("i");
        res = set.toString();
        assertEquals("",res);    
    }
    
    @Test
    public void test_intersection() {
        StringSet s1 = new StringSet();
        StringSet s2 = new StringSet();
        StringSet sres;
        String res;
        
        s1.add("a");
        s1.add("c");
        s1.add("e");
        
        sres = s1.intersection(s2);
        res = sres.toString();
        assertEquals("",res);
        
        s2.add("o");
        s2.add("p");
        s2.add("q");
        
        sres = s2.intersection(s1);
        res = sres.toString();
        assertEquals("",res);
        
        s1.add("d");
        s1.add("f");
        s1.add("o");
        s2.add("d");
        s2.add("f");
        
        sres = s1.intersection(s2);
        res = sres.toString();
        assertEquals("d\nf\no\n",res);
        
        sres = s1.intersection(s1);
        res = sres.toString();
        assertEquals("a\nc\nd\ne\nf\no\n",res);       
    }
    
        @Test
    public void test_union() {
        StringSet s1 = new StringSet();
        StringSet s2 = new StringSet();
        StringSet sres;
        String res;
        
        s1.add("a");
        s1.add("c");
        s1.add("e");
        
        sres = s1.union(s2);
        res = sres.toString();
        assertEquals("a\nc\ne\n",res);
        
        s2.add("o");
        s2.add("p");
        s2.add("q");
        
        sres = s2.union(s1);
        res = sres.toString();
        assertEquals("a\nc\ne\no\np\nq\n",res);
        
        s1.add("d");
        s1.add("f");
        s1.add("o");
        s2.add("d");
        s2.add("f");
        
        sres = s1.union(s2);
        res = sres.toString();
        assertEquals("a\nc\nd\ne\nf\no\np\nq\n",res);
        
        sres = s1.union(s1);
        res = sres.toString();
        assertEquals(s1.toString(),res);       
    }
}
