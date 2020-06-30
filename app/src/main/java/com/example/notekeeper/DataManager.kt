package com.example.notekeeper

class DataManager {
    val courses = HashMap<String, CourseInfo>()
    val notes = ArrayList<NoteInfo>()

    init {
        initialiseCourses()
    }

    private fun initialiseCourses(){
        var course = CourseInfo("android_intents", "Android Programming with Intents")
        courses.set(course.courseId,course)

        course = CourseInfo("android_async","Android Async Programming an Services")
        courses.set(course.courseId,course)

        course = CourseInfo("java_lang", "Java Fundamentals")
        courses.set(course.courseId,course)

        course = CourseInfo("java_core","Java Fundamentals: The core platform")
        courses.set(course.courseId,course)
    }
}