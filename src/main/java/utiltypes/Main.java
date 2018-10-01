package utiltypes;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

/**
 * @author GHajba
 */
public class Main {

    public static void main(String[] args) throws ParseException {
        final Configuration configuration = new Configuration().configure();

        final StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml");
        final SessionFactory factory = configuration.buildSessionFactory(builder.build());
        final Session session = factory.openSession();
        session.beginTransaction();

        // create a patient
        Patient patient = new Patient("John Doe", new SimpleDateFormat("yyyy-MM-dd").parse("1977-07-19"));
        session.save(patient);

        // add some examination information
        Examination bp = new Examination("blood pressure", "128/80", new SimpleDateFormat("yyyy-MM-dd HH:mm").parse("2018-09-29 11:22"), patient);
        Examination temp = new Examination("temperature", "36.9°C", new SimpleDateFormat("yyyy-MM-dd HH:mm").parse("2018-09-28 11:55"), patient);

        session.save(bp);
        session.save(temp);
        session.getTransaction().commit();

        // retrieve data from the database

        session.close();
        factory.close();
    }
}
