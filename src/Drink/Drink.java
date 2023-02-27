package Drink;

public abstract class Drink {
    private String m_name;
    private double m_value;

    public Drink()
    {

    }

    public String GetName()
    {
        return m_name;
    }

    public double GetValue()
    {
        return m_value;
    }

    public void SetName(String name)
    {
        this.m_name = name;
    }

    public void SetValue(double value)
    {
        this.m_value = value;
    }

    @Override
    public String toString()
    {
        return String.format(" - %s: $%.2f", m_name, m_value);
    }
}
