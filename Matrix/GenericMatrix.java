package Matrix;

public class GenericMatrix<T> implements Matrix<T> {

  private T[][] matrix;
  private int rowCount;
  private int columnCount;


  public GenericMatrix() {
    this(0, 0);
  }

  public GenericMatrix(int rowCount, int columnCount) {
    matrix = (T[][]) new Object[rowCount][columnCount];
    this.rowCount = rowCount;
    this.columnCount = columnCount;
  }

  public GenericMatrix(GenericMatrix<T> matrix) {
    this(matrix.rowCount, matrix.columnCount);
    for (int i = 1; i <= rowCount; i++) {
      for (int j = 1; j <= columnCount; j++) {
        this.matrix[i - 1][j - 1] = matrix.get(i, j);
      }
    }
  }

  @Override
  public void add(T el, int row, int column) {
    if (checkOutOfBounds(row, column)) {
      throw new IndexOutOfBoundsException("Raw or column out of range. Raw: " + row
          + ", column: " + column);
    }
    matrix[row - 1][column - 1] = el;
  }

  @Override
  public void remove(int row, int column) {
    if (checkOutOfBounds(row, column)) {
      throw new IndexOutOfBoundsException("Raw or column out of range. Raw: " + row
          + ", column: " + column);
    }
    matrix[row - 1][column - 1] = null;
  }

  @Override
  public T get(int row, int column) {
    if (checkOutOfBounds(row, column)) {
      throw new IndexOutOfBoundsException("Raw or column out of range. Raw: " + row
          + ", column: " + column);
    }
    return matrix[row - 1][column - 1];
  }

  public boolean checkOutOfBounds(int row, int column) {
    return row > rowCount || row <= 0 || column > columnCount || column <= 0;
  }
}
