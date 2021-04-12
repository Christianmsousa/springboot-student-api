package com.christian.modelonovo.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QCourseDomain is a Querydsl query type for CourseDomain
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QCourseDomain extends EntityPathBase<CourseDomain> {

    private static final long serialVersionUID = -1155605411L;

    public static final QCourseDomain courseDomain = new QCourseDomain("courseDomain");

    public final NumberPath<Long> duration = createNumber("duration", Long.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath name = createString("name");

    public final ListPath<StudentDomain, QStudentDomain> students = this.<StudentDomain, QStudentDomain>createList("students", StudentDomain.class, QStudentDomain.class, PathInits.DIRECT2);

    public final ListPath<SubjectDomain, QSubjectDomain> subjects = this.<SubjectDomain, QSubjectDomain>createList("subjects", SubjectDomain.class, QSubjectDomain.class, PathInits.DIRECT2);

    public QCourseDomain(String variable) {
        super(CourseDomain.class, forVariable(variable));
    }

    public QCourseDomain(Path<? extends CourseDomain> path) {
        super(path.getType(), path.getMetadata());
    }

    public QCourseDomain(PathMetadata metadata) {
        super(CourseDomain.class, metadata);
    }

}

