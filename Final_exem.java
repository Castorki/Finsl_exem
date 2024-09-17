import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Final_exem {
    public static final int fields_number = 6;

    public  static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        scanner.close();

        String[] fields = input.split(" ");
        if (fields.length!= fields_number){
            System.err.println("Неверное количество полей, вы ввели" + fields.length + ", введите 6 полей");
        }

        String lastname = fields[0];
        String firstname = fields[1];
        String middlemen = fields[2];

        LocalDate birthdate = null;
        try{
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
            birthdate = LocalDate.parse(fields[3], formatter);
        }
        catch (DateTimeParseException e){
            System.err.println("Неверный формат даты рождения, используйте формат dd.MM.yyyy");
        }

        long phoneNumber = 0;
        try{
            phoneNumber = Long.parseLong(fields[4]);
        }
        catch (NumberFormatException e){
            System.err.println("Неверный формат номера телефона");
        }

        String gender = fields[5];
        if((!"m".equals(gender)) && (!"f".equals(gender))){
            System.err.println("Неверный формат поля, введите f или m");
        }

        String fileName = lastname + ".txt";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))){
            writer.write(lastname + " " + firstname + " " + middlemen + " " + birthdate.format(DateTimeFormatter.ISO_LOCAL_DATE) + " " + phoneNumber + " " + gender);
            writer.newLine();
        }
        catch (IOException e){
            System.out.println("Ошибка записи");
        }
    }
}