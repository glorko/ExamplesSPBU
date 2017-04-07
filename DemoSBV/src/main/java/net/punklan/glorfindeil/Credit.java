package net.punklan.glorfindeil;

/**
 * Created by st020794 on 07.04.2017.
 */
public class Credit {
    public Credit(Integer sum, String name) {
        this.sum = sum;
        this.name = name;
    }

    private Integer sum;
    private String name;

    public Integer getSum() {
        return sum;
    }

    public void setSum(Integer sum) {
        this.sum = sum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
