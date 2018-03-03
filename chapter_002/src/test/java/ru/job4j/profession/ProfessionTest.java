package ru.job4j.profession;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test
 * @author Maxim Zlobin (mailto:hlabn@yandex.ru)
 * @since 03.03.2018
 * @version 0.1
 */
public class ProfessionTest {
    /**
     * Тест метода heal класса Doctor
     */
    @Test
    public void testDoctor() {
        Doctor doctor = new Doctor("Василий");
        Pacient pacient = new Pacient("Николай");
        String disease = "грипп";
        Diagnose result = doctor.heal(pacient, disease);
        assertThat(result.getName(), is(disease));
    }
    /**
     * Тест метода build класса Engineer
     */
    @Test
    public void testEngineer() {
        Engineer engineer = new Engineer("Артём", "Инженер-строитель");
        String type = "блочный пятиэтажный дом";
        House result = engineer.build(type);
        assertThat(result.getType(), is(type));
        assertThat(engineer.getProfession(), is("Инженер-строитель"));
    }
    /**
     * Тест метода teach класса Teacher
     */
    @Test
    public void testTeacher() {
        Teacher teacher = new Teacher("Сергей", "Младший преподаватель");
        Student student = new Student("Анастасия");
        String subject = "Сила притяжения кровати";
        Knowledge result = teacher.teach(student, subject);
        assertThat(result.getSubject(), is(subject));
        assertThat(teacher.getProfession(), is("Младший преподаватель"));
    }
}
