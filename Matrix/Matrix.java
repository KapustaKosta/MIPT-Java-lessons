package Matrix;

public interface Matrix<T> {

  public void add(T el, int raw, int column);

  public void remove(int raw, int column);

  public T get(int raw, int column);
}
