package Assignment;

import java.util.Scanner;

public class OnlineBookStore {
    static String[][] bookList = {
            {"ID2401", "쉽게 배우는 자바 프로그래밍 2판", "우종정", "한빛아카데미", "20,000원"},
            {"ID2402", "코딩 자율학습 HTML+CSS+자바스크립트", "김기수", "길벗", "30,000원"},
            {"ID2403", "Do It! 자료구조와 함께 배우는 알고리즘 입문 - 자바편", "보요시바타", "이지스퍼블리싱", "25,000원"}
    };

    static int[] cartList = new int[bookList.length];
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        displayWelcome();

        boolean quit = false;
        while (!quit) {
            int menu = displayGetMenu();
            switch (menu) {
                case 1:
                    menuBookList();
                    break;
                case 2:
                    menuCartList();
                    break;
                case 3:
                    menuAddCartItem();
                    break;
                case 4:
                    menuClearCart();
                    break;
                case 0:
                    menuExit();
                    quit = true;
                    break;
                default:
                    menuWrongNumber();
            }
        }
    }
    
    // 환영 인사
    public static void displayWelcome() {
        System.out.println("*****************************************");
        System.out.println("*    Welcome to Seoyoung Book Market    *");
        System.out.println("*****************************************");
    }
    
    // 메뉴 출력 후 메뉴 입력 받기
    public static int displayGetMenu() {
        System.out.println("=========================================");
        System.out.println("1. 도서 목록 보기");
        System.out.println("2. 장바구니 보기");
        System.out.println("3. 장바구니에 도서 추가");
        System.out.println("4. 장바구니 비우기");
        System.out.println("0. 종료");
        System.out.println("=========================================");
        System.out.print(">> 메뉴 선택 : ");
        return scanner.nextInt();
    }
    
    // 판매 도서 보기
    public static void menuBookList() {
        System.out.println(">> 도서 목록");
        System.out.println("------------------------------------------------------------------------");
        for (String[] book : bookList) {		
            System.out.print(book[0] + ", ");
            for (int i = 1; i < book.length; i++) {
                System.out.print(book[i] + ", ");
            }
            System.out.println();
        }
        System.out.println("------------------------------------------------------------------------");
    }
    
    // 장바구니 보기
    public static void menuCartList() {
        System.out.println(">> 장바구니 보기");
        boolean isEmpty = true;
        for (int i = 0; i < cartList.length; i++) {
            if (cartList[i] > 0) {
                isEmpty = false;
                System.out.println(cartList[i] + "권, " + bookList[i][0] + ", " + bookList[i][1] + ", " + bookList[i][2] +
                        ", " + bookList[i][3] + ", " + bookList[i][4] + ", ");
            }
        }
        // 장바구니가 비어 있으면
        if (isEmpty) {
            System.out.println(">> 장바구니가 비어 있습니다.");
        }
    }
    
    // 장바구니에 도서 추가
    public static void menuAddCartItem() {
        System.out.println(">> 장바구니에 도서 추가");
        menuBookList();
        System.out.print(">> 추가할 도서 ID 입력 : ");
        String bookID = scanner.next();
        boolean found = false;
        for (int i = 0; i < bookList.length; i++) {
            if (bookList[i][0].equals(bookID)) {
                cartList[i]++;
                System.out.println(">> 장바구니 추가 : " + bookList[i][1]);
                found = true;
                break;
            }
        }
        // ID를 잘못 입력한 경우
        if (!found) {
            System.out.println(">> 없는 ID입니다. 도서 목록에 있는 ID를 입력하세요.");
        }
    }

    // 장바구니 비우기
    public static void menuClearCart() {
        System.out.println(">> 장바구니 비우기");
        boolean isEmpty = true;
        for (int i = 0; i < cartList.length; i++) {
            if (cartList[i] > 0) {
                cartList[i] = 0;
                isEmpty = false;
            }
        }
        if (isEmpty) {
            System.out.println(">> 장바구니가 이미 비어 있습니다.");
        } else {
            System.out.println(">> 장바구니에 있는 아이템을 모두 삭제하였습니다.");
        }
    }
    
    // 종료
    public static void menuExit() {
        System.out.println(">> Seoyoung Book Market을 종료합니다.");
    }

    // 입력된 숫자가 메뉴 번호가 아니면, 메뉴 번호가 아님을 알려줌
    public static void menuWrongNumber() {
        System.out.println(">> 없는 메뉴입니다. 0번부터 4번까지의 메뉴 중에서 선택하세요.");
    }
}