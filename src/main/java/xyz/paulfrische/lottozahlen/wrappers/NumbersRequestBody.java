package xyz.paulfrische.lottozahlen.wrappers;

public class NumbersRequestBody {

    private Short number1 = 0;
    private Short number2 = 0;
    private Short number3 = 0;
    private Short number4 = 0;
    private Short number5 = 0;
    private Short number6 = 0;

    public String toString() {
        return number1 + " " + number2 + " " + number3 + " " + number4 + " " + number5 + " " + number6;
    }

    public short getNumber1() {
        if (number1.equals(null)) {
            return 0;
        }
        return number1;
    }

    public void setNumber1(short number1) {
        this.number1 = number1;
    }

    public short getNumber2() {
        if (number2.equals(null)) {
            return 0;
        }
        return number2;
    }

    public void setNumber2(short number2) {
        this.number2 = number2;
    }

    public short getNumber3() {
        if (number3.equals(null)) {
            return 0;
        }
        return number3;
    }

    public void setNumber3(short number3) {
        this.number3 = number3;
    }

    public short getNumber4() {
        if (number4.equals(null)) {
            return 0;
        }
        return number4;
    }

    public void setNumber4(short number4) {
        this.number4 = number4;
    }

    public short getNumber5() {
        if (number5.equals(null)) {
            return 0;
        }
        return number5;
    }

    public void setNumber5(short number5) {
        this.number5 = number5;
    }

    public short getNumber6() {
        if (number6.equals(null)) {
            return 0;
        }
        return number6;
    }

    public void setNumber6(short number6) {
        this.number6 = number6;
    }
}
