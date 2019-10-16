// IBookManager.aidl
package com.basic.android.book;

// Declare any non-default types here with import statements
import com.basic.android.book.Book;

interface IBookManager {
    List<Book> getBookList();
    void addBook(in Book book);
}
