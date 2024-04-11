package Task5;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Note {
  ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();
  public final List<String> notes = new ArrayList<>();

  public void addNote(int index, String note) {
    System.out.println("Сейчас будет добавлена заметка [" + note + "] На позицию " + index);
    readWriteLock.writeLock().lock();
    notes.add(index, note);
    readWriteLock.writeLock().unlock();
    System.out.println("Уже добавлена заметка [" + note + "]");
  }

  public void removeNote(int index) {
    System.out.println("Сейчас будет удалена заметка с позиции " + index);
    String note;
    readWriteLock.writeLock().lock();
    note = notes.remove(index);
    readWriteLock.writeLock().unlock();
    System.out.println("Уже удалена заметка [" + note + "] с позиции " + index);
  }

  public void readNote(int index) {
    System.out.println("Сейчас будет прочтена заметка с позиции " + index);
    String note;
    readWriteLock.readLock().lock();
    note = notes.get(index);
    readWriteLock.readLock().unlock();
    System.out.println("Прочтена заметка [" + note + "] с позиции " + index);
  }
}