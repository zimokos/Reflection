package ua.dp.zymokos.heorhii;

public class Animal {
    public String first = "100";
    private Integer second = 100;
    private Double third = 100.0;

    public Animal() {
    }

    public Animal(String first, Integer second, Double third) {
        this.first = first;
        this.second = second;
        this.third = third;
    }

    public String getFirst() {
        return first;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    public Integer getSecond() {
        return second;
    }

    public void setSecond(Integer second) {
        this.second = second;
    }

    public Double getThird() {
        return third;
    }

    public void setThird(Double third) {
        this.third = third;
    }
}
