package com.christian.modelonovo.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QStudentDomain is a Querydsl query type for StudentDomain
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QStudentDomain extends EntityPathBase<StudentDomain> {

    private static final long serialVersionUID = -2005277951L;

    public static final QStudentDomain studentDomain = new QStudentDomain("studentDomain");

    public final NumberPath<Long> age = createNumber("age", Long.class);

    public final ListPath<CourseDomain, QCourseDomain> courses = this.<CourseDomain, QCourseDomain>createList("courses", CourseDomain.class, QCourseDomain.class, PathInits.DIRECT2);

    public final StringPath email = createString("email");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath name = createString("name");

    public QStudentDomain(String variable) {
        super(StudentDomain.class, forVariable(variable));
    }

    public QStudentDomain(Path<? extends StudentDomain> path) {
        super(path.getType(), path.getMetadata());
    }

    public QStudentDomain(PathMetadata metadata) {
        super(StudentDomain.class, metadata);
    }

}

