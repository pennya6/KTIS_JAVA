package com.example.batchprocessing;

import org.springframework.batch.item.ItemProcessor;

public class PersonItemProcessor implements ItemProcessor<Person,Person> {
    //중간프로세서 만들기

    @Override
    public Person process(final Person person) throws Exception {
        final String firstName= person.getFirstName().toUpperCase();
        final String lastName= person.getLastName().toUpperCase();

        final Person transformedPerson=new Person(firstName,lastName);

        System.out.println(person+" -> "+transformedPerson);
        return transformedPerson;
    }
}
