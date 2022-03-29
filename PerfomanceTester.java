import java.util.HashMap;
import java.util.Queue;

public class PerfomanceTester {

    private class TestItem{

        private String name, type, desc;
        private int iterations;
        private long start, end, execTime;

        public TestItem(String name){
            this.name = name;
            this.iterations = 0;
        }

        public TestItem(String name, String type){
            this.name = name;
            this.type = type;
            this.iterations = 0;
        }

        public TestItem(String name, String type, String desc){
            this.name = name;
            this.type = type;
            this.desc = desc;
            this.iterations = 0;
        }

        public String getName(){
            return name;
        }

        public String getType(){
            return type;
        }

        public String getDesc(){
            return desc;
        }

        public void startTime(){
            this.start = System.nanoTime();
            this.iterations = 0;
        }

        public void endTime(){
            end = System.nanoTime();
            execTime = end - start;
        }

        public double getTimeMillis(){
            return execTime/1000000.0;
        }

        public void countIteration(){
            iterations++;
        }

        public int getIterations(){
            return iterations;
        }

    }

    private static PerfomanceTester uniqueInstance;

    private HashMap<String,TestItem> tests;

    private TestItem currentTest;
    
    private PerfomanceTester(){
        tests = new HashMap<>();
    }

    public static synchronized PerfomanceTester getInstance(){
        if (uniqueInstance == null)
			uniqueInstance = new PerfomanceTester();

		return uniqueInstance;
    }

    public void addTest(String name){
        tests.put(name, new TestItem(name));
    }

    public void addTest(String name, String type){
        tests.put(name, new TestItem(name,type));
    }

    public void addTest(String name, String type, String desc){
        tests.put(name, new TestItem(name,type,desc));
    }
    
    public void start(String name){
        currentTest = tests.get(name);
        currentTest.startTime();
    }

    public void end(){
        currentTest.endTime();
    }

    public void countIter(){
        currentTest.countIteration();
    }

    public String getReport(String name){
        TestItem i = tests.get(name);
        String result = "--------------------------%n" +
                        "%s%n"+
                        "Iterations: %d%n" + 
                        "Execution time: %fms%n"+
                        "--------------------------";
        return String.format(result,name,i.getIterations(),i.getTimeMillis());
    }
}
