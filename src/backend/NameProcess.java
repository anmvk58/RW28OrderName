package backend;

import entity.Name;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class NameProcess {
    List<Name> nameList;
    Scanner scanner;

    public NameProcess() {
        nameList = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    public void mainMethod(){
        System.out.println("Bạn muốn nhập bao nhiêu học sinh ?");
        int n = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < n; i++){
            System.out.println("Mời nhập tên thứ " + (i+1));
            String temp = scanner.nextLine();
            //Chuẩn hóa xâu
            temp = chuanHoaXau(temp);
            // Add chuỗi vào đối tượng Name
            AddName(temp);
        }

        // Sắp xếp:
        System.out.println("Danh sách tên đã được sắp xếp: ");
        Collections.sort(nameList);
        for(Name s : nameList){
            System.out.println(s);
        }
    }

    public String chuanHoaXau(String input){
        input = input.trim();
        while(input.indexOf("  ") != -1){
            input = input.replaceAll("  ", " ");
        }
        return  input;
    }

    public void AddName(String input){
        int n = input.length();
        List<Integer> index = new ArrayList<>();
        for(int i = 0; i < n; i++){
            if(input.charAt(i) == ' '){
                index.add(i);
            }
        }
        // trường hợp ko có tên Lót
        if(index.size()<2) {
            String lastname = input.substring(0, index.get(0));
            String firstname = input.substring(index.get(0)+1, n);
            String middlename = "";
            Name tempName = new Name(lastname, middlename, firstname);
            nameList.add(tempName);
        } else {
            String lastname = input.substring(0, index.get(0));
            String firstname = input.substring(index.get(index.size()-1)+1, n);
            String middlename = input.substring(index.get(0)+1,index.get(index.size()-1));
            Name tempName = new Name(lastname, middlename, firstname);
            nameList.add(tempName);
        }

    }

}
