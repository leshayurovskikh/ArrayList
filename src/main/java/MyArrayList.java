/**
 * Класс, представляющий реализацию основных методов ArrayList.
 */
public class MyArrayList<T> {
    private Object[] elements;
    private int size;
    private static final int DEFAULT_CAPACITY = 10;

    public MyArrayList() {
        elements = new Object[DEFAULT_CAPACITY];
        size = 0;
    }
    /**
     * Добавляет элементы в массив
     *
     * @param element элемент который добавляем в массив
     */
    public void add(T element) {
        if (size == elements.length) {
            increaseCapacity();
        }
        elements[size++] = element;
    }
    /**
     * Добавляет элементы в массив
     *
     * @param index индекс элемента который мы хотим удалить
     * @return возвращает массив с удаленным элементом по индексу
     */
    public T remove(int index) {
        checkIndex(index);
        T removedElement = (T) elements[index];
        for (int i = index; i < size - 1; i++) {
            elements[i] = elements[i + 1];
        }
        elements[--size] = null;
        return removedElement;
    }
    /**
     * Получает элемент массива по индексу
     *
     * @param index индекс элемента который мы хотим получить
     * @return возвращает элемент по индексу
     */
    public T get(int index) {
        checkIndex(index);
        return (T) elements[index];
    }
    /**
     * Изменяет элемент в массив по индексу
     *
     * @param index индекс элемента который мы хотим изменить
     */
    public void set(int index, T element) {
        checkIndex(index);
        elements[index] = element;
    }
    /**
     * Возвращает представление части массива между указанными индексами fromIndex (включительно) и toIndex (исключительно)
     *
     * @param fromIndex индекс элемента с которого мы хотим получить
     * @param toIndex индекс элемента по который мы хотим получить
     * @return возвращает список элементов по указанным индексам
     * @exception IndexOutOfBoundsException
     */
    public MyArrayList<T> subList(int fromIndex, int toIndex) {
        if (fromIndex < 0 || toIndex > size || fromIndex > toIndex) {
            throw new IndexOutOfBoundsException("Invalid sublist range");
        }
        MyArrayList<T> subList = new MyArrayList<>();
        for (int i = fromIndex; i < toIndex; i++) {
            subList.add((T) elements[i]);
        }
        return subList;
    }
    /**
     * Возвращает размер массива
     */
    public int size() {
        return size;
    }
    /**
     * Увеличивает емкость массива при добавлении новых элементов.
     */
    private void increaseCapacity() {
        int newCapacity = elements.length * 2;
        Object[] newArray = new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newArray[i] = elements[i];
        }
        elements = newArray;
    }
    /**
     * Проверяет, что индекс действителен. Если нет, выбрасывает исключение IndexOutOfBoundsException
     * @exception IndexOutOfBoundsException
     */
    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Индекс: " + index + ", Размер: " + size);
        }
    }
}
