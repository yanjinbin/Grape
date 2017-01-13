package NIO.serializable;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Silver Bullet
 * @since 一月-10
 */

public class HumanResourcesApplication {

    private static final Logger log = Logger.getLogger(HumanResourcesApplication.class.getName());
    private static final String SOURCE_CLASS =HumanResourcesApplication.class.getName();

    public static List<Employee> createEmloyees(){
        List<Employee> employees = new ArrayList<Employee>();
        Employee e = new Employee(12,"john");
        Employee e1 = new Employee(13,"smith");
        Employee e2 = new Employee(14,"cat");
        Employee e3 = new Employee(15,"Kevin");
        employees.add(e);
        employees.add(e1);
        employees.add(e2);
        employees.add(e3);
        return  employees;
    }

    public  boolean serialize2Disk(String filename,List<Employee> employees){
        final String METHOD_NAME = "serialize2Disk(String filename, List<Employee> employees)";
        boolean ret = false;
        File file = new File(filename);
        try {
            ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(file));
            log.info("Writing " + employees.size() + " employees to disk (using Serializable)...");
            outputStream.writeObject(employees);
            ret = true;
            log.info("done finished");
        } catch (IOException e) {
            log.logp(Level.SEVERE, SOURCE_CLASS, METHOD_NAME, "Cannot find file " +
                    file.getName() + ", message = " + e.getLocalizedMessage(), e);
        }
        return ret;
    }

    @SuppressWarnings("unchecked")
    public List<Employee> deserializeFromDisk(String filename) {
        final String METHOD_NAME = "deserializeFromDisk(String filename)";

        List<Employee> ret = new ArrayList<Employee>();
        File file = new File(filename);
        int numberOfEmployees = 0;
        try {
            ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(file));
            List<Employee> employees = (List<Employee>)inputStream.readObject();
            log.info("Deserialized List says it contains " + employees.size() +
                    " objects...");
            for (Employee employee : employees) {
                log.info("Read Employee: " + employee.toString());
                numberOfEmployees++;
            }
            ret = employees;
            log.info("Read " + numberOfEmployees + " employees from disk.");
        } catch (FileNotFoundException e) {
            log.logp(Level.SEVERE, SOURCE_CLASS, METHOD_NAME, "Cannot find file " +
                    file.getName() + ", message = " + e.getLocalizedMessage(), e);
        } catch (IOException e) {
            log.logp(Level.SEVERE, SOURCE_CLASS, METHOD_NAME, "IOException occurred"+ e.getLocalizedMessage(), e);
        } catch (ClassNotFoundException e) {
            log.logp(Level.SEVERE, SOURCE_CLASS, METHOD_NAME, "ClassNotFoundException"
                     + e.getLocalizedMessage(), e);
        }
        return ret;
    }
}
