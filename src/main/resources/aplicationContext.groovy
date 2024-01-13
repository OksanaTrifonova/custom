import com.laba.book_shop.controller.BookController
import com.laba.book_shop.mapper.BookMapper

import com.laba.book_shop.service.BookService


beans {
    importBeans('classpath:repositoryBean.xml')
    mapper(BookMapper)
    service(BookService){
        mapper=mapper
        bookRepository=bookRepository
        bookRepository=bookRepository
    }
    controller(BookController){
        service=service
    }
}
