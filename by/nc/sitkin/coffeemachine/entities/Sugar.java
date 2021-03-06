package by.nc.sitkin.coffeemachine.entities;

import by.nc.sitkin.coffeemachine.interfaces.Countable;

public class Sugar extends Ingredient implements Countable {
    private static int counter = 0;

    public Sugar(){
        this.cost = new Cash();
        counter++;
    }

    public Sugar(Cash cost){
        this.cost = cost;
        counter++;
    }

    public int getCounter(){
        return counter;
    }

    public void decrement(){
        counter--;
    }

    @Override
    public boolean equals(Object obj){
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Sugar other = (Sugar) obj;
        return getCost().equals(other.getCost());
    }

    @Override
    public int hashCode(){
        final int prime = 23;
        int result = 31;
        result = prime * result + getClass().getSimpleName().hashCode();
        result = prime * result + getCounter();
        result = prime * result + getCost().hashCode();
        return result;
    }

    @Override
    public String toString(){
        return "" + getClass().getSimpleName() + "@" +
                getCost().getDollars() + "." + getCost().getCents();
    }

}
