// IBookManager.aidl
package com.basic.android.aidl;

// Declare any non-default types here with import statements
import com.basic.android.aidl.Book;

interface IBookManager {
    List<Book> getBookList();
    void addBook(in Book book);
}
