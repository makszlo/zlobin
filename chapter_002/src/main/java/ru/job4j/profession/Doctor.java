package ru.job4j.profession;

/**
 * Класс профессии доктор
 */
public class Doctor extends Profession {
    /**
     * Конструктор для создания объекта доктор
     * @param name - имя доктора
     */
    public Doctor(String name) {
        super(name, "Доктор");
    }

    /**
     * Конструктор для создания объекта доктор, в случае если профессия доктора имеет отличное от стандартного название
     * @param name - имя доктора
     * @param profession - профессия
     */
    public Doctor(String name, String profession) {
        super(name, profession);
    }

    /**
     * Метод поставноки диагноза пациенту
     * @return - диагноз пациента
     */
    public Diagnose heal(Pacient pacient, String disease) {
        pacient.diagnose = new Diagnose(disease);
        return pacient.diagnose;
    }
}

