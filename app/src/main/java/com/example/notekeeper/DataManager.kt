package com.example.notekeeper

object DataManager {
    val courses = HashMap<String, CourseInfo>()
    val notes = ArrayList<NoteInfo>()

    init {
        initialiseCourses()
        initialiseNotes()
    }

    private fun initialiseNotes() {
        var note = NoteInfo(
            CourseInfo("android_intents", "Android Programming with Intents"),"Android Programming with Intents",
            "rtnehrjwhtkeht,lkrh;kyjltjyhtjkhkjgjerbtjrlhuthjrnjyljtlu,ymu;jkrmuhjylyjkjrtjkyktjkyl;lyyklhjlkyjhjbtjjlhkljkl;jllkj.k,.j;l;jljhoifhjytp[';")
        notes.add(note)
        note = NoteInfo(CourseInfo("android_async","Android Async Programming an Services"),"Android Async Programming an Services", "jhiiobuhuyi7rr5tvygboiju876renb34d5654ertfghbjiikn bvhgfcftvg .title,")
        notes.add(note)
        note = NoteInfo(CourseInfo("java_lang", "Java Fundamentals"),"Java Fundamentals", "course.title,")
        notes.add(note)
        note = NoteInfo(CourseInfo("java_core","Java Fundamentals: The core platform"),"Java Fundamentals: The core platform", "kn;lhgtdrghfswrdfcgjuhl;njjnijgyb7jbkknohyiu67nioojjjjjjknobl")
        notes.add(note)
        note = NoteInfo(CourseInfo("android_async","Android Async Programming an Services"),"Android Async Programming an Services", "course.title,")
        notes.add(note)
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