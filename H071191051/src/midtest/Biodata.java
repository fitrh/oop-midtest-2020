package midtest;

import java.text.*;
import java.time.*;
import java.util.*;

class Biodata extends TodoList {
    private String name;
    private String dateOfBirth;
    private String nim;
    private String age;
    private String faculty;
    private int registerYear;
    private String email;

    public Biodata() {

    }

    public Biodata(String name, String dateOfBirth, String nim, String callName) {
        super(callName);
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.nim = nim;
    }

    @Override
    public String getDescription() {
        String data = "\nNama           : " + getName() + "\n" + "Nama panggilan : " + super.getCallName() + "\n"
                + "Tanggal lahir  : " + getDateOfBirth() + "\n" + "Umur           : " + getAge() + "\n"
                + "NIM            : " + getNim() + "\n" + "Fakultas       : " + getFaculty() + "\n"
                + "Angkatan       : " + getRegisterYear() + "\n" + "Email          : " + getEmail() + "\n";
        return data;
    }

    public void setAge(String age) throws ParseException {
        String s = age;
        SimpleDateFormat dateForm = new SimpleDateFormat("yyyy/MM/dd");
        Date d = dateForm.parse(s);
        Calendar c = Calendar.getInstance();
        c.setTime(d);

        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH) + 1;
        int date = c.get(Calendar.DATE);

        LocalDate birth = LocalDate.of(year, month, date);
        LocalDate now = LocalDate.now();
        Period difference = Period.between(birth, now);
        this.age = String.valueOf(difference.getYears()) + " tahun";
    }

    public void setFaculty(Map<Character, String> faculty) {
        this.faculty = faculty.get(nim.charAt(0));
    }

    public void setRegisterYear(String nim) {
        this.registerYear = 2000 + Integer.parseInt(nim.substring(4, 6));
    }

    public void setEmail(String name) {
        String[] emailName = name.split(" ");
        String s = "";
        for (int i = 0; i < emailName.length - 1; i++) {
            s = s + emailName[i].charAt(0);
        }
        this.email = (emailName[emailName.length - 1] + s + String.valueOf(registerYear).substring(2, 4) + nim.charAt(0)
                + "@student.unhas.ac.id").toLowerCase();
    }

    public String getName() {
        String fullName = name.toLowerCase();
        String fixName = "";
        for (int i = 0; i < fullName.length(); i++) {
            if (i == 0 || fullName.codePointBefore(i) == 32) {
                fixName = fixName + ((char) (fullName.codePointAt(i) - 32));
            } else {
                fixName = fixName + fullName.charAt(i);
            }
        }
        return fixName;
    }

    public String getDateOfBirth() {
        String[] str = dateOfBirth.split("-");
        String birthDay = "";
        for (int i = str.length - 1; i > -1; i--) {
            birthDay = birthDay + str[i] + "/";
        }
        return birthDay.substring(0, birthDay.length() - 1);
    }

    public String getNim() {
        return nim;
    }

    public String getAge() {
        return age;
    }

    public String getFaculty() {
        return faculty;
    }

    public int getRegisterYear() {
        return registerYear;
    }

    public String getEmail() {
        return email;
    }
}