public class IntHolder {
  private int num;
  public IntHolder(int num)
  {
    this.num = num;
  }

  public static IntHolder build(int num)
  {
    return new IntHolder(num);
  }

  public void plus(IntHolder intHolder)
  {
    this.num += intHolder.num;
  }

  public void subtract(IntHolder intHolder)
  {
    this.num -= intHolder.num;
  }

  public void multiply(IntHolder intHolder)
  {
    this.num *= intHolder.num;
  }

  public void divide(IntHolder intHolder)
  {
    this.num /= intHolder.num;
  }

  public void modulo(IntHolder intHolder)
  {
    this.num %= intHolder.num;
  }

  public static void swap(IntHolder holder1, IntHolder holder2)
  {
    int temp = holder1.num;
    holder1.num = holder2.num;
    holder2.num = temp;
  }

  @Override
  public boolean equals(Object o)
  {
    if(o instanceof IntHolder holder)
    {
      return this.num == holder.num;
    }

    return false;
  }

  @Override
  public int hashCode()
  {
    return this.num;
  }
}
