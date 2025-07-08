2025-07-07T23:22:37.147+07:00  INFO 9416 --- [test] [nio-8080-exec-1] o.a.c.c.C.[Tomcat].[localhost].[/]       : Initializing Spring DispatcherServlet 'dispatcherServlet'
2025-07-07T23:22:37.148+07:00  INFO 9416 --- [test] [nio-8080-exec-1] o.s.web.servlet.DispatcherServlet        : Initializing Servlet 'dispatcherServlet'
2025-07-07T23:22:37.149+07:00  INFO 9416 --- [test] [nio-8080-exec-1] o.s.web.servlet.DispatcherServlet        : Completed initialization in 1 ms
Hibernate:
    select
        u1_0.user_id,
        u1_0.status_id,
        u1_0.username
    from
        users u1_0
    offset
        ? rows
    fetch
        first ? rows only
Hibernate:
    select
        a1_0.address_id,
        a1_0.street,
        a1_0.user_id,
        u1_0.user_id,
        u1_0.status_id,
        u1_0.username
    from
        user_address a1_0
    join
        users u1_0
            on u1_0.user_id=a1_0.user_id
    where
        a1_0.user_id=?
Hibernate:
    select
        a1_0.address_id,
        a1_0.street,
        a1_0.user_id,
        u1_0.user_id,
        u1_0.status_id,
        u1_0.username
    from
        user_address a1_0
    join
        users u1_0
            on u1_0.user_id=a1_0.user_id
    where
        a1_0.user_id=?
Hibernate:
    select
        p1_0.user_id,
        p1_0.first_name,
        p1_0.last_name,
        p1_0.profile_status_id
    from
        profile p1_0
    where
        p1_0.user_id=?
Hibernate:
    select
        ps1_0.profile_status_id,
        ps1_0.status_name
    from
        profile_status ps1_0
    where
        ps1_0.profile_status_id=?
Hibernate:
    select
        us1_0.status_id,
        us1_0.status_name
    from
        user_status us1_0
    where
        us1_0.status_id=?
Hibernate:
    select
        o1_0.order_id,
        o1_0.created_at,
        o1_0.description,
        o1_0.order_status_id,
        s1_0.order_status_id,
        s1_0.created_at,
        s1_0.status_name,
        o1_0.user_id
    from
        orders o1_0
    left join
        order_status s1_0
            on s1_0.order_status_id=o1_0.order_status_id
    where
        o1_0.user_id=?
    order by
        o1_0.created_at
    fetch
        first ? rows only
Hibernate:
    select
        p1_0.user_id,
        p1_0.first_name,
        p1_0.last_name,
        p1_0.profile_status_id
    from
        profile p1_0
    where
        p1_0.user_id=?
Hibernate:
    select
        o1_0.order_id,
        o1_0.created_at,
        o1_0.description,
        o1_0.order_status_id,
        s1_0.order_status_id,
        s1_0.created_at,
        s1_0.status_name,
        o1_0.user_id
    from
        orders o1_0
    left join
        order_status s1_0
            on s1_0.order_status_id=o1_0.order_status_id
    where
        o1_0.user_id=?
    order by
        o1_0.created_at
    fetch
        first ? rows only
End debug
