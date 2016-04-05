package com.kj;
import org.springframework.data.mongodb.repository.MongoRepository; 
public interface ContactRepository extends MongoRepository<Contact, String> {}

