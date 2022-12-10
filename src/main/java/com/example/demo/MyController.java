package com.example.demo;


import com.example.demo.entity.*;
import com.example.demo.service.*;
import com.example.demo.service.calendar.CalendarEstimatesService;
import com.example.demo.service.calendarpass.CalendarPassService;
import com.example.demo.service.finalgrade.FinalGradesService;
import com.example.demo.service.semester.SemesterAssessmentService;
import com.example.demo.service.spravka.ReferenceService;
import com.example.demo.service.teachers.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.io.IOException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


@Controller
public class MyController {
    private static String author;
    @Autowired
    private PeopleService peopleService;
    @Autowired
    private SemesterAssessmentService semesterAssessmentService;

    @Autowired
    private FinalGradesService finalGradesService;

    @Autowired
    private ReferenceService referenceService;

    @Autowired
    private CalendarEstimatesService calendarEstimatesService;

    @Autowired
    private CalendarPassService calendarPassService;

    @Autowired
    private TeacherService teacherService;

    @GetMapping("/")
    public String getInfoForAllEmps(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Boolean isInput = authentication.isAuthenticated();
        model.addAttribute("isInput", isInput);
        try {
            Authentication authentication2 = SecurityContextHolder.getContext().getAuthentication();
            author = authentication2.getName();
            List<People> peopleList = peopleService.findAllByUsername(author);
            model.addAttribute("people", peopleList.get(0));
        } catch (IndexOutOfBoundsException e) {

        }
        return "index";
    }

    @GetMapping("/login")
    public String getLogin(@RequestParam(value = "error", required = false) String error,
                           @RequestParam(value = "error", required = false) String logout,
                           Model model) {
        model.addAttribute("error", error != null);
        model.addAttribute("logout", logout != null);
        model.addAttribute("text", "Максим");
        return "sign-in";
    }

    @GetMapping("/exchange")
    public String showInfoExchange(Model model) {
        try {
            List<People> peopleList = peopleService.findAllByUsername(author);
            model.addAttribute("people", peopleList.get(0));
        } catch (IndexOutOfBoundsException e) {

        }
        return "exchange";
    }

    @GetMapping("/shedule")
    public String showInfoShedule(Model model) {
        try {
            List<People> peopleList = peopleService.findAllByUsername(author);
            model.addAttribute("people", peopleList.get(0));
        } catch (IndexOutOfBoundsException e) {

        }
        return "shedule";
    }

    @GetMapping("/specialty")
    public String showInfoSpecialty(Model model) {
        try {
            List<People> peopleList = peopleService.findAllByUsername(author);
            model.addAttribute("people", peopleList.get(0));
        } catch (IndexOutOfBoundsException e) {

        }
        return "specialty";
    }

    @GetMapping("/resourses")
    public String showInfoResourses(Model model) {
        try {
            List<People> peopleList = peopleService.findAllByUsername(author);
            model.addAttribute("people", peopleList.get(0));
        } catch (IndexOutOfBoundsException e) {

        }
        return "resourses";
    }

    @GetMapping("/educator")
    public String showInfoEducator(@Valid @ModelAttribute("studentInfo") StudentInfo studentInfo1, BindingResult bindingResult, Model model) {
        try {
            String stringStudent = studentInfo1.getFistLastMiddleName();
            HashMap<String, String> hashMap = new HashMap<>();
            List<People> peopleList = peopleService.findAllByUsername(author);
            model.addAttribute("people", peopleList.get(0));
            List<Teacher> teacherList = teacherService.findAllBy();

            for (Teacher teacher : teacherList) {
                String str = teacher.getLastName() + " " + teacher.getFirstName() + " " + teacher.getMiddleName();
                String id = teacher.getTeacher();
                hashMap.put(id, str);
            }
            StudentInfo studentInfo = new StudentInfo();
            studentInfo.setFistLastMiddleNames(hashMap);
            studentInfo.setFistLastMiddleName(stringStudent);
            model.addAttribute("studentInfo", studentInfo);
            if (stringStudent != null) {
                List<Teacher> teacherList1 = teacherService.findAllByTeacher(stringStudent);
                model.addAttribute("teacher", teacherList1);
            }
        } catch (IndexOutOfBoundsException e) {
            String stringStudent = studentInfo1.getFistLastMiddleName();
            HashMap<String, String> hashMap = new HashMap<>();
            List<Teacher> teacherList = teacherService.findAllBy();

            for (Teacher teacher : teacherList) {
                String str = teacher.getLastName() + " " + teacher.getFirstName() + " " + teacher.getMiddleName();
                String id = teacher.getTeacher();
                hashMap.put(id, str);
            }
            StudentInfo studentInfo = new StudentInfo();
            studentInfo.setFistLastMiddleNames(hashMap);
            studentInfo.setFistLastMiddleName(stringStudent);
            model.addAttribute("studentInfo", studentInfo);
            if (stringStudent != null) {
                List<Teacher> teacherList1 = teacherService.findAllByTeacher(stringStudent);
                model.addAttribute("teacher", teacherList1);
            }
        }
        return "educator";
    }

    @GetMapping("/contacts")
    public String showInfoContacts(Model model) {
        try {
            List<People> peopleList = peopleService.findAllByUsername(author);
            model.addAttribute("people", peopleList.get(0));
        } catch (IndexOutOfBoundsException e) {

        }
        return "contacts";
    }

    @GetMapping("/profile")
    public String getProfile(Model model) {
        try {
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            String currentPrincipalName = authentication.getName();
            //Запрос
            author = currentPrincipalName;
            List<People> peopleList = peopleService.findAllByUsername(currentPrincipalName);
            model.addAttribute("people", peopleList.get(0));
        } catch (Exception e) {

        }
        return "fio";
    }

    @GetMapping("/enquiry")
    public String showInfoEnquiry(Model model) {
        try {
            List<People> peopleList = peopleService.findAllByUsername(author);
            model.addAttribute("people", peopleList.get(0));
            List<Reference> referenceList = referenceService.findAllByStudent(author);
            model.addAttribute("reference", referenceList);
        } catch (Exception e) {

        }
        return "enquiry";
    }

    @Autowired
    private FileUploadService fileUploadService;

    @PostMapping("/update")
    public String uploadFile(@RequestParam("file") MultipartFile file, RedirectAttributes redirectAttributes, Model model) {
        try {
            fileUploadService.uploadFile(file);
            List<People> peopleList = peopleService.findAllByUsername(author);
            People people = peopleList.get(0);
            model.addAttribute("people", people);
            String[] arr = file.getContentType().split("/");
            String strArr = arr[0];
            if (!strArr.equals("image")) {
                throw new Exception();
            }
            if (file.getOriginalFilename() != null) {
                referenceService.saveReference(new Reference(people.getTeacher(), people.getUsername(), people.getFirstName(), people.getMiddleName(), people.getLastName(), people.getGroup_name(), file.getOriginalFilename()));
                List<Reference> referenceList = referenceService.findAllByStudent(author);
                model.addAttribute("reference", referenceList);
            } else {
                model.addAttribute("error", "Вы не выбрали файл");
            }
        } catch (Exception e) {
            List<People> peopleList = peopleService.findAllByUsername(author);
            People people = peopleList.get(0);
            model.addAttribute("people", people);
            model.addAttribute("error", "Можно отправлять только фотографии");
        }
        return "enquiry";
    }


    @GetMapping("/enquiry-d")
    public String showInfoEnquiry_d(@Valid @ModelAttribute("estimates") Estimates estimates, BindingResult bindingResult, Model model) {
        String temp = estimates.getMonths();
        List<People> peopleList = peopleService.findAllByUsername(author);
        model.addAttribute("people", peopleList.get(0));
        if (temp == null) {
            model.addAttribute("estimates", new Estimates());
        }
        if (temp != null) {
            Estimates estimates1 = new Estimates();
            estimates1.setMonths(temp);
            model.addAttribute("estimates", estimates1);
        }
        if (temp == null || temp.equals("Сентябрь")) {
            List<CalendarEstimates> calendarEstimates = calendarEstimatesService.findAllByStudentAndMonth(author, "Сентябрь");
            model.addAttribute("calendar", calendarEstimates);
            model.addAttribute("mounthe", "Оценки за Сентябрь");
            return "enquiry-d";
        } else if (temp.equals("Октябрь")) {
            List<CalendarEstimates> calendarEstimates = calendarEstimatesService.findAllByStudentAndMonth(author, temp);
            model.addAttribute("calendar", calendarEstimates);
            model.addAttribute("mounthe", "Оценки за " + temp);
            return "enquiry-d31";
        } else if (temp.equals("Ноябрь")) {
            List<CalendarEstimates> calendarEstimates = calendarEstimatesService.findAllByStudentAndMonth(author, temp);
            model.addAttribute("calendar", calendarEstimates);
            model.addAttribute("mounthe", "Оценки за " + temp);
            return "enquiry-d";
        } else if (temp.equals("Декабрь")) {
            List<CalendarEstimates> calendarEstimates = calendarEstimatesService.findAllByStudentAndMonth(author, temp);
            model.addAttribute("calendar", calendarEstimates);
            model.addAttribute("mounthe", "Оценки за " + temp);
            return "enquiry-d31";
        } else if (temp.equals("Январь")) {
            List<CalendarEstimates> calendarEstimates = calendarEstimatesService.findAllByStudentAndMonth(author, temp);
            model.addAttribute("calendar", calendarEstimates);
            model.addAttribute("mounthe", "Оценки за " + temp);
            return "enquiry-d31";
        } else if (temp.equals("Февраль")) {
            List<CalendarEstimates> calendarEstimates = calendarEstimatesService.findAllByStudentAndMonth(author, temp);
            model.addAttribute("calendar", calendarEstimates);
            model.addAttribute("mounthe", "Оценки за " + temp);
            return "enquiry-d28";
        } else if (temp.equals("Март")) {
            List<CalendarEstimates> calendarEstimates = calendarEstimatesService.findAllByStudentAndMonth(author, temp);
            model.addAttribute("calendar", calendarEstimates);
            model.addAttribute("mounthe", "Оценки за " + temp);
            return "enquiry-d31";
        } else if (temp.equals("Апрель")) {
            List<CalendarEstimates> calendarEstimates = calendarEstimatesService.findAllByStudentAndMonth(author, temp);
            model.addAttribute("calendar", calendarEstimates);
            model.addAttribute("mounthe", "Оценки за " + temp);
            return "enquiry-d";
        } else if (temp.equals("Май")) {
            List<CalendarEstimates> calendarEstimates = calendarEstimatesService.findAllByStudentAndMonth(author, temp);
            model.addAttribute("calendar", calendarEstimates);
            model.addAttribute("mounthe", "Оценки за " + temp);
            return "enquiry-d31";
        } else if (temp.equals("Июнь")) {
            List<CalendarEstimates> calendarEstimates = calendarEstimatesService.findAllByStudentAndMonth(author, temp);
            model.addAttribute("calendar", calendarEstimates);
            model.addAttribute("mounthe", "Оценки за " + temp);
            return "enquiry-d";
        }
        return "enquiry-d";
    }

    @GetMapping("/enquiry-m")
    public String showInfoEnquiry_m(@Valid @ModelAttribute("semesters") Semester semester, @Valid @ModelAttribute("calculator") Calculator calculator, BindingResult bindingResult, Model model) {
        String temp = semester.getSemesters();
        try {
            List<People> peopleList = peopleService.findAllByUsername(author);
            model.addAttribute("people", peopleList.get(0));
            String month = calculator.getAverageMonth();
            String credit = calculator.getCreditMonth();
            if (month == null || credit == null) {
                model.addAttribute("calculator", new Calculator());
            }
            if (month != null && credit != null) {
                int result = 0;
                Calculator calculator1 = new Calculator();

                calculator1.setAverageMonth(month);
                calculator1.setCreditMonth(credit);
                int mouth2 = Integer.parseInt(month);
                int credit2 = Integer.parseInt(credit);
                double temp60 = (mouth2 * 0.60);
                double temp40 = (credit2 * 0.40);
                result = (int) (temp40 + temp60);
                model.addAttribute("calculator", calculator1);
                model.addAttribute("resultCalculator", result);

            }
            if (temp == null) {
                model.addAttribute("semesters", new Semester());
            }
            if (temp != null) {
                Semester semester1 = new Semester();
                semester1.setSemesters(temp);
                model.addAttribute("semesters", semester1);
            }
            if (temp == null || temp.equals("За 1 семестр")) {
                List<SemesterAssessment> semesterAssessmentList = semesterAssessmentService.findAllByStudentAndSemester(author, "1");
                model.addAttribute("semester", semesterAssessmentList);
                model.addAttribute("numberSemester", temp);
                return "enquiry-m";
            } else if (temp.equals("За 2 семестр")) {
                List<SemesterAssessment> semesterAssessmentList = semesterAssessmentService.findAllByStudentAndSemester(author, "2");
                model.addAttribute("semester", semesterAssessmentList);
                model.addAttribute("numberSemester", temp);
                return "enquiry-m";
            }
        } catch (Exception e) {
            model.addAttribute("error", "Можно водить только цифры");
            model.addAttribute("numberSemester", temp);
            return "enquiry-m";
        }
        return "null";
    }

    @GetMapping("/enquiry-td")
    public String showInfoEnquiry_td(@Valid @ModelAttribute("schedules") Schedule schedule, BindingResult bindingResult, Model model) {
        try {
            String group = schedule.getNameGroup();
            String mouth = schedule.getMonth();
            String item = schedule.getNameItem();
            String status = schedule.getStatus();
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            author = authentication.getName();
            List<People> peopleList = peopleService.findAllByUsername(author);
            model.addAttribute("people", peopleList.get(0));

            List<CalendarEstimates> calendarEstimatesList = calendarEstimatesService.findAllByTeacher(author);

            Schedule schedule2 = new Schedule();
            HashMap<String, String> groups = new HashMap<>();
            HashMap<String, String> items = new HashMap<>();
            for (int i = 0; i < calendarEstimatesList.size(); i++) {
                CalendarEstimates septemberEstimates = calendarEstimatesList.get(i);
                String groupName = septemberEstimates.getGroupName();
                String itemName = septemberEstimates.getItemName();
                groups.put(groupName, groupName);
                items.put(itemName, itemName);
            }

            if (status == null) {
                schedule2.setNameGroups(groups);
                schedule2.setNameItems(items);
            } else if (status.equals("Журнал оценок")) {
                schedule2.setNameGroups(groups);
                schedule2.setNameItems(items);
                schedule2.setNameGroup("Группа: " + group);
                schedule2.setMonth("Оценки за месяц: " + mouth);
                schedule2.setNameItem("Предмет: " + item);
                schedule2.setStatus(status);
                schedule2.setMonth(mouth);
                schedule2.setNameItem(item);
                schedule2.setNameGroup(group);
            } else if (status.equals("Журнал посещения")) {
                schedule2.setNameGroups(groups);
                schedule2.setNameItems(items);
                schedule2.setNameGroup("Группа: " + group);
                schedule2.setMonth("Журнал посещения за месяц: " + mouth);
                schedule2.setNameItem("Предмет: " + item);
                schedule2.setStatus(status);
                schedule2.setMonth(mouth);
                schedule2.setNameItem(item);
                schedule2.setNameGroup(group);
            }

            model.addAttribute("schedules", schedule2);

            if (mouth == null || mouth.equals("Сентябрь") && status.equals("Журнал оценок")) {
                List<CalendarEstimates> calendarEstimatesList1 = calendarEstimatesService.findAllByTeacherAndGroupNameAndItemNameAndMonth(author, group, item, mouth);
                model.addAttribute("calendar", calendarEstimatesList1);
                return "enquiry-td";
            }
            if (mouth.equals("Октябрь") && status.equals("Журнал оценок")) {
                List<CalendarEstimates> calendarEstimatesList1 = calendarEstimatesService.findAllByTeacherAndGroupNameAndItemNameAndMonth(author, group, item, mouth);
                model.addAttribute("calendar", calendarEstimatesList1);
                return "enquiry-td31";
            }
            if (mouth.equals("Ноябрь") && status.equals("Журнал оценок")) {
                List<CalendarEstimates> calendarEstimatesList1 = calendarEstimatesService.findAllByTeacherAndGroupNameAndItemNameAndMonth(author, group, item, mouth);
                model.addAttribute("calendar", calendarEstimatesList1);
                return "enquiry-td";
            }
            if (mouth.equals("Декабрь") && status.equals("Журнал оценок")) {
                List<CalendarEstimates> calendarEstimatesList1 = calendarEstimatesService.findAllByTeacherAndGroupNameAndItemNameAndMonth(author, group, item, mouth);
                model.addAttribute("calendar", calendarEstimatesList1);
                return "enquiry-td31";
            }
            if (mouth.equals("Январь") && status.equals("Журнал оценок")) {
                List<CalendarEstimates> calendarEstimatesList1 = calendarEstimatesService.findAllByTeacherAndGroupNameAndItemNameAndMonth(author, group, item, mouth);
                model.addAttribute("calendar", calendarEstimatesList1);
                return "enquiry-td31";
            }
            if (mouth.equals("Февраль") && status.equals("Журнал оценок")) {
                List<CalendarEstimates> calendarEstimatesList1 = calendarEstimatesService.findAllByTeacherAndGroupNameAndItemNameAndMonth(author, group, item, mouth);
                model.addAttribute("calendar", calendarEstimatesList1);
                return "enquiry-td28";
            }
            if (mouth.equals("Март") && status.equals("Журнал оценок")) {
                List<CalendarEstimates> calendarEstimatesList1 = calendarEstimatesService.findAllByTeacherAndGroupNameAndItemNameAndMonth(author, group, item, mouth);
                model.addAttribute("calendar", calendarEstimatesList1);
                return "enquiry-td31";
            }
            if (mouth.equals("Апрель") && status.equals("Журнал оценок")) {
                List<CalendarEstimates> calendarEstimatesList1 = calendarEstimatesService.findAllByTeacherAndGroupNameAndItemNameAndMonth(author, group, item, mouth);
                model.addAttribute("calendar", calendarEstimatesList1);
                return "enquiry-td";
            }
            if (mouth.equals("Май") && status.equals("Журнал оценок")) {
                List<CalendarEstimates> calendarEstimatesList1 = calendarEstimatesService.findAllByTeacherAndGroupNameAndItemNameAndMonth(author, group, item, mouth);
                model.addAttribute("calendar", calendarEstimatesList1);
                return "enquiry-td31";
            }
            if (mouth.equals("Июнь") && status.equals("Журнал оценок")) {
                List<CalendarEstimates> calendarEstimatesList1 = calendarEstimatesService.findAllByTeacherAndGroupNameAndItemNameAndMonth(author, group, item, mouth);
                model.addAttribute("calendar", calendarEstimatesList1);
                return "enquiry-td";
            }
            //Журнал посещения
            if (mouth == null || mouth.equals("Сентябрь") && status.equals("Журнал посещения")) {
                List<CalendarPass> calendarPassList = calendarPassService.findAllByTeacherAndGroupNameAndItemNameAndMonth(author, group, item, mouth);
                model.addAttribute("calendar", calendarPassList);
                return "enquiry-tdt";
            }
            if (mouth.equals("Октябрь") && status.equals("Журнал посещения")) {
                List<CalendarPass> calendarPassList = calendarPassService.findAllByTeacherAndGroupNameAndItemNameAndMonth(author, group, item, mouth);
                model.addAttribute("calendar", calendarPassList);
                return "enquiry-tdt31";
            }
            if (mouth.equals("Ноябрь") && status.equals("Журнал посещения")) {
                List<CalendarPass> calendarPassList = calendarPassService.findAllByTeacherAndGroupNameAndItemNameAndMonth(author, group, item, mouth);
                model.addAttribute("calendar", calendarPassList);
                return "enquiry-tdt";
            }
            if (mouth.equals("Декабрь") && status.equals("Журнал посещения")) {
                List<CalendarPass> calendarPassList = calendarPassService.findAllByTeacherAndGroupNameAndItemNameAndMonth(author, group, item, mouth);
                model.addAttribute("calendar", calendarPassList);
                return "enquiry-tdt31";
            }
            if (mouth.equals("Январь") && status.equals("Журнал посещения")) {
                List<CalendarPass> calendarPassList = calendarPassService.findAllByTeacherAndGroupNameAndItemNameAndMonth(author, group, item, mouth);
                model.addAttribute("calendar", calendarPassList);
                return "enquiry-tdt31";
            }
            if (mouth.equals("Февраль") && status.equals("Журнал посещения")) {
                List<CalendarPass> calendarPassList = calendarPassService.findAllByTeacherAndGroupNameAndItemNameAndMonth(author, group, item, mouth);
                model.addAttribute("calendar", calendarPassList);
                return "enquiry-tdt28";
            }
            if (mouth.equals("Март") && status.equals("Журнал посещения")) {
                List<CalendarPass> calendarPassList = calendarPassService.findAllByTeacherAndGroupNameAndItemNameAndMonth(author, group, item, mouth);
                model.addAttribute("calendar", calendarPassList);
                return "enquiry-tdt31";
            }
            if (mouth.equals("Апрель") && status.equals("Журнал посещения")) {
                List<CalendarPass> calendarPassList = calendarPassService.findAllByTeacherAndGroupNameAndItemNameAndMonth(author, group, item, mouth);
                model.addAttribute("calendar", calendarPassList);
                return "enquiry-tdt";
            }
            if (mouth.equals("Май") && status.equals("Журнал посещения")) {
                List<CalendarPass> calendarPassList = calendarPassService.findAllByTeacherAndGroupNameAndItemNameAndMonth(author, group, item, mouth);
                model.addAttribute("calendar", calendarPassList);
                return "enquiry-tdt31";
            }
            if (mouth.equals("Июнь") && status.equals("Журнал посещения")) {
                List<CalendarPass> calendarPassList = calendarPassService.findAllByTeacherAndGroupNameAndItemNameAndMonth(author, group, item, mouth);
                model.addAttribute("calendar", calendarPassList);
                return "enquiry-tdt";
            }
        } catch (Exception e) {
        }
        return "enquiry-td";
    }

    @GetMapping("/enquiry-tm") //TODO
    public String showInfoEnquiry_tm(@Valid @ModelAttribute("attestations") AttestationAssessments attestationAssessments2, @Valid @ModelAttribute("calculator") Calculator calculator, BindingResult bindingResult, Model model) {
        try {
            String group = attestationAssessments2.getNameGroup();
            String item = attestationAssessments2.getNameItem();
            String semesters = attestationAssessments2.getSemester();
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            author = authentication.getName();
            List<People> peopleList = peopleService.findAllByUsername(author);
            model.addAttribute("people", peopleList.get(0));

            List<SemesterAssessment> semesterAssessmentList = semesterAssessmentService.findAllByTeacher(author);
            AttestationAssessments attestationAssessments = new AttestationAssessments();
            HashMap<String, String> groups = new HashMap<>();
            HashMap<String, String> items = new HashMap<>();
            for (int i = 0; i < semesterAssessmentList.size(); i++) {
                SemesterAssessment semesterAssessment = semesterAssessmentList.get(i);
                String groupName = semesterAssessment.getGroupName();
                String itemName = semesterAssessment.getItemName();
                groups.put(groupName, groupName);
                items.put(itemName, itemName);
            }
            attestationAssessments.setNameGroups(groups);
            attestationAssessments.setNameItems(items);
            if (group != null && item != null && semesters != null) {
                attestationAssessments.setNameGroup(group);
                attestationAssessments.setNameItem(item);
                attestationAssessments.setSemester(semesters);
            }

            model.addAttribute("attestations", attestationAssessments);
            String month = calculator.getAverageMonth();
            String credit = calculator.getCreditMonth();
            if (month == null || credit == null) {
                model.addAttribute("calculator", new Calculator());
            }
            if (month != null && credit != null) {
                Calculator calculator1 = new Calculator();

                calculator1.setAverageMonth(month);
                calculator1.setCreditMonth(credit);
                int mouth2 = Integer.parseInt(month);
                int credit2 = Integer.parseInt(credit);
                double temp60 = (mouth2 * 0.60);
                double temp40 = (credit2 * 0.40);
                int result = (int) (temp40 + temp60);
                System.out.println(result);
                model.addAttribute("calculator", calculator1);
                model.addAttribute("resultCalculator", result);

            }
            if (semesters != null) {
                if (semesters.equals("1")) {
                    List<SemesterAssessment> semesterAssessmentList1 = semesterAssessmentService.findAllByTeacherAndGroupNameAndItemNameAndSemester(author, group, item, semesters);
                    model.addAttribute("semesterAssessment", semesterAssessmentList1);
                    model.addAttribute("NameGroup", "Группа: " + semesterAssessmentList1.get(0).getGroupName());
                    model.addAttribute("NameItem", "Предмет: " + semesterAssessmentList1.get(0).getItemName());
                    model.addAttribute("NameSemester", "За " + semesterAssessmentList1.get(0).getSemester() + " семестр");
                    return "enquiry-tm";
                } else {
                    List<SemesterAssessment> semesterAssessmentList1 = semesterAssessmentService.findAllByTeacherAndGroupNameAndItemNameAndSemester(author, group, item, semesters);
                    model.addAttribute("semesterAssessment", semesterAssessmentList1);
                    model.addAttribute("NameGroup", "Группа: " + semesterAssessmentList1.get(0).getGroupName());
                    model.addAttribute("NameItem", "Предмет: " + semesterAssessmentList1.get(0).getItemName());
                    model.addAttribute("NameSemester", "За " + semesterAssessmentList1.get(0).getSemester() + " семестр");
                    return "enquiry-tm";
                }
            }
        } catch (Exception e) {
            model.addAttribute("errorrs", "Можно водить только цифры");
            return "enquiry-tm";
        }
        return "enquiry-tm";
    }

    @GetMapping("/enquiry-tq")
    public String showInfoEnquiry_tq(Model model) {
        try {
            List<People> peopleList = peopleService.findAllByUsername(author);
            model.addAttribute("people", peopleList.get(0));
        } catch (Exception e) {

        }
        return "enquiry-tq";
    }

    @GetMapping("/fio_t")
    public String showInfoFio_t(@Valid @ModelAttribute("studentInfo") StudentInfo studentInfo1, BindingResult bindingResult, Model model) {
        try {
            String stringStudent = studentInfo1.getFistLastMiddleName();
            HashMap<String, String> hashMap = new HashMap<>();
            List<People> peopleList = peopleService.findAllByUsername(author);
            model.addAttribute("people", peopleList.get(0));
            List<People> studentList = peopleService.findAllByTeacher(author);

            for (People people : studentList) {
                String str = people.getLastName() + " " + people.getFirstName() + " " + people.getMiddleName();
                String id = String.valueOf(people.getId());
                if (!hashMap.containsValue(str) && !peopleList.get(0).getUsername().equals(people.getUsername())) {
                    hashMap.put(id, str);
                } else if (hashMap.size() == 0 && !peopleList.get(0).getUsername().equals(people.getUsername())) {
                    hashMap.put(id, str);
                }
            }
            StudentInfo studentInfo = new StudentInfo();
            studentInfo.setFistLastMiddleNames(hashMap);
            studentInfo.setFistLastMiddleName(stringStudent);
            model.addAttribute("studentInfo", studentInfo);
            if (stringStudent != null) {
                List<People> studentList2 = peopleService.findAllById(Integer.parseInt(stringStudent));
                model.addAttribute("student", studentList2.get(0));
            }

        } catch (Exception e) {

        }
        return "fio_t";
    }

    @GetMapping("/enquiry_t")
    public String showInfoEnquiry_t(@Valid @ModelAttribute("studentInfo") StudentInfo studentInfo1, BindingResult bindingResult, Model model) {
        try {
            String stringStudent = studentInfo1.getFistLastMiddleName();
            HashMap<String, String> hashMap = new HashMap<>();
            List<People> peopleList = peopleService.findAllByUsername(author);
            model.addAttribute("people", peopleList.get(0));
            List<People> studentList = peopleService.findAllByTeacher(author);
            for (People people : studentList) {
                String str = people.getLastName() + " " + people.getFirstName() + " " + people.getMiddleName();
                String id = people.getUsername();
                if (!hashMap.containsValue(str) && !peopleList.get(0).getUsername().equals(people.getUsername())) {
                    hashMap.put(id, str);
                } else if (hashMap.size() == 0 && !peopleList.get(0).getUsername().equals(people.getUsername())) {
                    hashMap.put(id, str);
                }
            }
            StudentInfo studentInfo = new StudentInfo();
            studentInfo.setFistLastMiddleNames(hashMap);
            studentInfo.setFistLastMiddleName(stringStudent);
            model.addAttribute("studentInfo", studentInfo);
            if (stringStudent != null) {
                List<Reference> referenceList = referenceService.findAllByStudent(stringStudent);
                System.out.println(stringStudent);
                System.out.println(referenceList);
                model.addAttribute("reference", referenceList);
            }

        } catch (Exception ignored) {
        }
        return "enquiry_t";
    }

    @GetMapping("/enquiry_update")
    public String updateEstimation(@ModelAttribute("empId") int id, Model model) {
        List<People> peopleList = peopleService.findAllByUsername(author);
        model.addAttribute("people", peopleList.get(0));
        List<CalendarEstimates> calendarEstimatesList = calendarEstimatesService.findAllById(id);
        CalendarEstimates calendarEstimates = calendarEstimatesList.get(0);
        model.addAttribute("calendarId", calendarEstimates);
        if (Integer.parseInt(calendarEstimates.getDays()) == 30) {
            return "enquiry_update";
        } else if (Integer.parseInt(calendarEstimates.getDays()) == 31) {
            return "enquiry_update31";
        } else {
            return "enquiry_update28";
        }
    }

    @PostMapping("enquiry_save")
    public String saveEmployee(@ModelAttribute("calendarId") CalendarEstimates calendarEstimates, Model model) {
        try {
            ArrayList<Integer> arrayList = new ArrayList<>();
            int count = 0;
            int sum = 0;
            int day1 = calendarEstimates.getDay1() != null && !calendarEstimates.getDay1().isEmpty() ? Integer.parseInt(calendarEstimates.getDay1().trim()) : -1;
            int day2 = calendarEstimates.getDay2() != null && !calendarEstimates.getDay2().isEmpty() ? Integer.parseInt(calendarEstimates.getDay2().trim()) : -1;
            int day3 = calendarEstimates.getDay3() != null && !calendarEstimates.getDay3().isEmpty() ? Integer.parseInt(calendarEstimates.getDay3().trim()) : -1;
            int day4 = calendarEstimates.getDay4() != null && !calendarEstimates.getDay4().isEmpty() ? Integer.parseInt(calendarEstimates.getDay4().trim()) : -1;
            int day5 = calendarEstimates.getDay5() != null && !calendarEstimates.getDay5().isEmpty() ? Integer.parseInt(calendarEstimates.getDay5().trim()) : -1;
            int day6 = calendarEstimates.getDay6() != null && !calendarEstimates.getDay6().isEmpty() ? Integer.parseInt(calendarEstimates.getDay6().trim()) : -1;
            int day7 = calendarEstimates.getDay7() != null && !calendarEstimates.getDay7().isEmpty() ? Integer.parseInt(calendarEstimates.getDay7().trim()) : -1;
            int day8 = calendarEstimates.getDay8() != null && !calendarEstimates.getDay8().isEmpty() ? Integer.parseInt(calendarEstimates.getDay8().trim()) : -1;
            int day9 = calendarEstimates.getDay9() != null && !calendarEstimates.getDay9().isEmpty() ? Integer.parseInt(calendarEstimates.getDay9().trim()) : -1;
            int day10 = calendarEstimates.getDay10() != null && !calendarEstimates.getDay10().isEmpty() ? Integer.parseInt(calendarEstimates.getDay10().trim()) : -1;
            int day11 = calendarEstimates.getDay11() != null && !calendarEstimates.getDay11().isEmpty() ? Integer.parseInt(calendarEstimates.getDay11().trim()) : -1;
            int day12 = calendarEstimates.getDay12() != null && !calendarEstimates.getDay12().isEmpty() ? Integer.parseInt(calendarEstimates.getDay12().trim()) : -1;
            int day13 = calendarEstimates.getDay13() != null && !calendarEstimates.getDay13().isEmpty() ? Integer.parseInt(calendarEstimates.getDay13().trim()) : -1;
            int day14 = calendarEstimates.getDay14() != null && !calendarEstimates.getDay14().isEmpty() ? Integer.parseInt(calendarEstimates.getDay14().trim()) : -1;
            int day15 = calendarEstimates.getDay15() != null && !calendarEstimates.getDay15().isEmpty() ? Integer.parseInt(calendarEstimates.getDay15().trim()) : -1;
            int day16 = calendarEstimates.getDay16() != null && !calendarEstimates.getDay16().isEmpty() ? Integer.parseInt(calendarEstimates.getDay16().trim()) : -1;
            int day17 = calendarEstimates.getDay17() != null && !calendarEstimates.getDay17().isEmpty() ? Integer.parseInt(calendarEstimates.getDay17().trim()) : -1;
            int day18 = calendarEstimates.getDay18() != null && !calendarEstimates.getDay18().isEmpty() ? Integer.parseInt(calendarEstimates.getDay18().trim()) : -1;
            int day19 = calendarEstimates.getDay19() != null && !calendarEstimates.getDay19().isEmpty() ? Integer.parseInt(calendarEstimates.getDay19().trim()) : -1;
            int day20 = calendarEstimates.getDay20() != null && !calendarEstimates.getDay20().isEmpty() ? Integer.parseInt(calendarEstimates.getDay20().trim()) : -1;
            int day21 = calendarEstimates.getDay21() != null && !calendarEstimates.getDay21().isEmpty() ? Integer.parseInt(calendarEstimates.getDay21().trim()) : -1;
            int day22 = calendarEstimates.getDay22() != null && !calendarEstimates.getDay22().isEmpty() ? Integer.parseInt(calendarEstimates.getDay22().trim()) : -1;
            int day23 = calendarEstimates.getDay23() != null && !calendarEstimates.getDay23().isEmpty() ? Integer.parseInt(calendarEstimates.getDay23().trim()) : -1;
            int day24 = calendarEstimates.getDay24() != null && !calendarEstimates.getDay24().isEmpty() ? Integer.parseInt(calendarEstimates.getDay24().trim()) : -1;
            int day25 = calendarEstimates.getDay25() != null && !calendarEstimates.getDay25().isEmpty() ? Integer.parseInt(calendarEstimates.getDay25().trim()) : -1;
            int day26 = calendarEstimates.getDay26() != null && !calendarEstimates.getDay26().isEmpty() ? Integer.parseInt(calendarEstimates.getDay26().trim()) : -1;
            int day27 = calendarEstimates.getDay27() != null && !calendarEstimates.getDay27().isEmpty() ? Integer.parseInt(calendarEstimates.getDay27().trim()) : -1;
            int day28 = calendarEstimates.getDay28() != null && !calendarEstimates.getDay28().isEmpty() ? Integer.parseInt(calendarEstimates.getDay28().trim()) : -1;
            int day29 = calendarEstimates.getDay29() != null && !calendarEstimates.getDay29().isEmpty() ? Integer.parseInt(calendarEstimates.getDay29().trim()) : -1;
            int day30 = calendarEstimates.getDay30() != null && !calendarEstimates.getDay30().isEmpty() ? Integer.parseInt(calendarEstimates.getDay30().trim()) : -1;
            int day31 = calendarEstimates.getDay31() != null && !calendarEstimates.getDay31().isEmpty() ? Integer.parseInt(calendarEstimates.getDay31().trim()) : -1;
            arrayList.add(day1);
            arrayList.add(day2);
            arrayList.add(day3);
            arrayList.add(day4);
            arrayList.add(day5);
            arrayList.add(day6);
            arrayList.add(day7);
            arrayList.add(day8);
            arrayList.add(day9);
            arrayList.add(day10);
            arrayList.add(day11);
            arrayList.add(day12);
            arrayList.add(day13);
            arrayList.add(day14);
            arrayList.add(day15);
            arrayList.add(day16);
            arrayList.add(day17);
            arrayList.add(day18);
            arrayList.add(day19);
            arrayList.add(day20);
            arrayList.add(day21);
            arrayList.add(day22);
            arrayList.add(day23);
            arrayList.add(day24);
            arrayList.add(day25);
            arrayList.add(day26);
            arrayList.add(day27);
            arrayList.add(day28);
            arrayList.add(day29);
            arrayList.add(day30);
            arrayList.add(day31);
            for (int temp : arrayList) {
                if (temp > 100 || temp < -1) {
                    throw new Exception();
                } else if (temp != -1) {
                    count++;
                    sum = sum + temp;
                }
            }
            String result = String.valueOf(sum / count);
            calendarEstimates.setResult(result);
            calendarEstimatesService.saveReference(calendarEstimates);
            return "redirect:/enquiry-td";
        } catch (Exception e) {
            if (Integer.parseInt(calendarEstimates.getDays()) == 30) {
                List<People> peopleList = peopleService.findAllByUsername(author);
                model.addAttribute("people", peopleList.get(0));
                model.addAttribute("calendarId", calendarEstimates);
                model.addAttribute("errors", "Вы ввели не в верном формате. В ведите только цифры от 0 до 100");
                return "enquiry_update";
            } else if (Integer.parseInt(calendarEstimates.getDays()) == 31) {
                List<People> peopleList = peopleService.findAllByUsername(author);
                model.addAttribute("people", peopleList.get(0));
                model.addAttribute("calendarId", calendarEstimates);
                model.addAttribute("errors", "Вы ввели не в верном формате. В ведите только цифры от 0 до 100");
                return "enquiry_update31";
            } else {
                List<People> peopleList = peopleService.findAllByUsername(author);
                model.addAttribute("people", peopleList.get(0));
                model.addAttribute("calendarId", calendarEstimates);
                model.addAttribute("errors", "Вы ввели не в верном формате. В ведите только цифры от 0 до 100");
                return "enquiry_update28";
            }
        }
    }

    @GetMapping("/enquiry_updateH")
    public String updateEstimationH(@ModelAttribute("empId") int id, Model model) {
        List<CalendarPass> calendarPassList = calendarPassService.findAllById(id);
        CalendarPass calendarPass = calendarPassList.get(0);
        model.addAttribute("calendarId", calendarPass);
        if (Integer.parseInt(calendarPass.getDays()) == 30) {
            return "enquiry_updateh";
        } else if (Integer.parseInt(calendarPass.getDays()) == 31) {
            return "enquiry_updateh31";
        } else {
            return "enquiry_updateh28";
        }
    }

    @PostMapping("enquiry_saveH")
    public String enquiry_saveH(@ModelAttribute("calendarId") CalendarPass calendarPass, Model model) {
        try {
            ArrayList<String> arrayList = new ArrayList<>();
            int count = 0;
            String day1 = calendarPass.getDay1() != null && !calendarPass.getDay1().isEmpty() ? calendarPass.getDay1().trim() : "F";
            String day2 = calendarPass.getDay2() != null && !calendarPass.getDay2().isEmpty() ? calendarPass.getDay2().trim() : "F";
            String day3 = calendarPass.getDay3() != null && !calendarPass.getDay3().isEmpty() ? calendarPass.getDay3().trim() : "F";
            String day4 = calendarPass.getDay4() != null && !calendarPass.getDay4().isEmpty() ? calendarPass.getDay4().trim() : "F";
            String day5 = calendarPass.getDay5() != null && !calendarPass.getDay5().isEmpty() ? calendarPass.getDay5().trim() : "F";
            String day6 = calendarPass.getDay6() != null && !calendarPass.getDay6().isEmpty() ? calendarPass.getDay6().trim() : "F";
            String day7 = calendarPass.getDay7() != null && !calendarPass.getDay7().isEmpty() ? calendarPass.getDay7().trim() : "F";
            String day8 = calendarPass.getDay8() != null && !calendarPass.getDay8().isEmpty() ? calendarPass.getDay8().trim() : "F";
            String day9 = calendarPass.getDay9() != null && !calendarPass.getDay9().isEmpty() ? calendarPass.getDay9().trim() : "F";
            String day10 = calendarPass.getDay10() != null && !calendarPass.getDay10().isEmpty() ? calendarPass.getDay10().trim() : "F";
            String day11 = calendarPass.getDay11() != null && !calendarPass.getDay11().isEmpty() ? calendarPass.getDay11().trim() : "F";
            String day12 = calendarPass.getDay12() != null && !calendarPass.getDay12().isEmpty() ? calendarPass.getDay12().trim() : "F";
            String day13 = calendarPass.getDay13() != null && !calendarPass.getDay13().isEmpty() ? calendarPass.getDay13().trim() : "F";
            String day14 = calendarPass.getDay14() != null && !calendarPass.getDay14().isEmpty() ? calendarPass.getDay14().trim() : "F";
            String day15 = calendarPass.getDay15() != null && !calendarPass.getDay15().isEmpty() ? calendarPass.getDay15().trim() : "F";
            String day16 = calendarPass.getDay16() != null && !calendarPass.getDay16().isEmpty() ? calendarPass.getDay16().trim() : "F";
            String day17 = calendarPass.getDay17() != null && !calendarPass.getDay17().isEmpty() ? calendarPass.getDay17().trim() : "F";
            String day18 = calendarPass.getDay18() != null && !calendarPass.getDay18().isEmpty() ? calendarPass.getDay18().trim() : "F";
            String day19 = calendarPass.getDay19() != null && !calendarPass.getDay19().isEmpty() ? calendarPass.getDay19().trim() : "F";
            String day20 = calendarPass.getDay20() != null && !calendarPass.getDay20().isEmpty() ? calendarPass.getDay20().trim() : "F";
            String day21 = calendarPass.getDay21() != null && !calendarPass.getDay21().isEmpty() ? calendarPass.getDay21().trim() : "F";
            String day22 = calendarPass.getDay22() != null && !calendarPass.getDay22().isEmpty() ? calendarPass.getDay22().trim() : "F";
            String day23 = calendarPass.getDay23() != null && !calendarPass.getDay23().isEmpty() ? calendarPass.getDay23().trim() : "F";
            String day24 = calendarPass.getDay24() != null && !calendarPass.getDay24().isEmpty() ? calendarPass.getDay24().trim() : "F";
            String day25 = calendarPass.getDay25() != null && !calendarPass.getDay25().isEmpty() ? calendarPass.getDay25().trim() : "F";
            String day26 = calendarPass.getDay26() != null && !calendarPass.getDay26().isEmpty() ? calendarPass.getDay26().trim() : "F";
            String day27 = calendarPass.getDay27() != null && !calendarPass.getDay27().isEmpty() ? calendarPass.getDay27().trim() : "F";
            String day28 = calendarPass.getDay28() != null && !calendarPass.getDay28().isEmpty() ? calendarPass.getDay28().trim() : "F";
            String day29 = calendarPass.getDay29() != null && !calendarPass.getDay29().isEmpty() ? calendarPass.getDay29().trim() : "F";
            String day30 = calendarPass.getDay30() != null && !calendarPass.getDay30().isEmpty() ? calendarPass.getDay30().trim() : "F";
            String day31 = calendarPass.getDay31() != null && !calendarPass.getDay31().isEmpty() ? calendarPass.getDay31().trim() : "F";
            arrayList.add(day1);
            arrayList.add(day2);
            arrayList.add(day3);
            arrayList.add(day4);
            arrayList.add(day5);
            arrayList.add(day6);
            arrayList.add(day7);
            arrayList.add(day8);
            arrayList.add(day9);
            arrayList.add(day10);
            arrayList.add(day11);
            arrayList.add(day12);
            arrayList.add(day13);
            arrayList.add(day14);
            arrayList.add(day15);
            arrayList.add(day16);
            arrayList.add(day17);
            arrayList.add(day18);
            arrayList.add(day19);
            arrayList.add(day20);
            arrayList.add(day21);
            arrayList.add(day22);
            arrayList.add(day23);
            arrayList.add(day24);
            arrayList.add(day25);
            arrayList.add(day26);
            arrayList.add(day27);
            arrayList.add(day28);
            arrayList.add(day29);
            arrayList.add(day30);
            arrayList.add(day31);
            for (String temp : arrayList) {
                if (!temp.equals("H") && !temp.equals("F") && !temp.equals("Н")) {
                    throw new Exception();
                } else if (!temp.equals("F")) {
                    count++;
                }
            }
            String result = String.valueOf(count);
            calendarPass.setResult(result);
            calendarPassService.saveReference(calendarPass);
            return "redirect:/enquiry-td";
        } catch (Exception e) {
            if (Integer.parseInt(calendarPass.getDays()) == 30) {
                model.addAttribute("calendarId", calendarPass);
                model.addAttribute("errors", "Вы ввели не в верном формате. В ведите только 'H'");
                return "enquiry_updateh";
            } else if (Integer.parseInt(calendarPass.getDays()) == 31) {
                model.addAttribute("errors", "Вы ввели не в верном формате. В ведите только 'H'");
                return "enquiry_updateh31";
            } else {
                model.addAttribute("errors", "Вы ввели не в верном формате. В ведите только 'H'");
                return "enquiry_updateh28";
            }
        }
    }

    @GetMapping("/enquiry_update_assessments")
    public String updateEstimationAssessments(@ModelAttribute("empId") int id, Model model) {
        List<People> peopleList = peopleService.findAllByUsername(author);
        model.addAttribute("people", peopleList.get(0));
        List<SemesterAssessment> semesterAssessmentList = semesterAssessmentService.findAllById(id);
        SemesterAssessment semesterAssessment = semesterAssessmentList.get(0);
        model.addAttribute("semesterAssessment", semesterAssessment);
        return "enquiry_update_assessments";
    }

    @PostMapping("enquiry_save_assessments")
    public String enquiry_saveAssessments(@ModelAttribute("semesterAssessment") SemesterAssessment semesterAssessment, Model model) {
        ArrayList<CalendarEstimates> calendarEstimatesArrayList = new ArrayList<>();

        try {
            int sum = 0;
            int count = 0;
            int result = 0;
            int creditWork = semesterAssessment.getCreditWork() != null && !semesterAssessment.getCreditWork().isEmpty() ? Integer.parseInt(semesterAssessment.getCreditWork().trim()) : -1;
            if (creditWork > 100 || creditWork < -1) {
                throw new Exception();
            }

            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            author = authentication.getName();

            if (semesterAssessment.getSemester().equals("1")) {
                List<CalendarEstimates> calendarEstimatesList = calendarEstimatesService.findAllByTeacherAndGroupNameAndItemNameAndMonthAndStudent(author, semesterAssessment.getGroupName(), semesterAssessment.getItemName(), "Сентябрь", semesterAssessment.getStudent());
                List<CalendarEstimates> calendarEstimatesList2 = calendarEstimatesService.findAllByTeacherAndGroupNameAndItemNameAndMonthAndStudent(author, semesterAssessment.getGroupName(), semesterAssessment.getItemName(), "Октябрь", semesterAssessment.getStudent());
                List<CalendarEstimates> calendarEstimatesList3 = calendarEstimatesService.findAllByTeacherAndGroupNameAndItemNameAndMonthAndStudent(author, semesterAssessment.getGroupName(), semesterAssessment.getItemName(), "Ноябрь", semesterAssessment.getStudent());
                List<CalendarEstimates> calendarEstimatesList4 = calendarEstimatesService.findAllByTeacherAndGroupNameAndItemNameAndMonthAndStudent(author, semesterAssessment.getGroupName(), semesterAssessment.getItemName(), "Декабрь", semesterAssessment.getStudent());
                List<CalendarEstimates> calendarEstimatesList5 = calendarEstimatesService.findAllByTeacherAndGroupNameAndItemNameAndMonthAndStudent(author, semesterAssessment.getGroupName(), semesterAssessment.getItemName(), "Январь", semesterAssessment.getStudent());
                calendarEstimatesArrayList.add(calendarEstimatesList.get(0));
                calendarEstimatesArrayList.add(calendarEstimatesList2.get(0));
                calendarEstimatesArrayList.add(calendarEstimatesList3.get(0));
                calendarEstimatesArrayList.add(calendarEstimatesList4.get(0));
                calendarEstimatesArrayList.add(calendarEstimatesList5.get(0));
            }

            if (semesterAssessment.getSemester().equals("2")) {
                List<CalendarEstimates> calendarEstimatesList = calendarEstimatesService.findAllByTeacherAndGroupNameAndItemNameAndMonthAndStudent(author, semesterAssessment.getGroupName(), semesterAssessment.getItemName(), "Февраль", semesterAssessment.getStudent());
                List<CalendarEstimates> calendarEstimatesList2 = calendarEstimatesService.findAllByTeacherAndGroupNameAndItemNameAndMonthAndStudent(author, semesterAssessment.getGroupName(), semesterAssessment.getItemName(), "Март", semesterAssessment.getStudent());
                List<CalendarEstimates> calendarEstimatesList3 = calendarEstimatesService.findAllByTeacherAndGroupNameAndItemNameAndMonthAndStudent(author, semesterAssessment.getGroupName(), semesterAssessment.getItemName(), "Апрель", semesterAssessment.getStudent());
                List<CalendarEstimates> calendarEstimatesList4 = calendarEstimatesService.findAllByTeacherAndGroupNameAndItemNameAndMonthAndStudent(author, semesterAssessment.getGroupName(), semesterAssessment.getItemName(), "Май", semesterAssessment.getStudent());
                List<CalendarEstimates> calendarEstimatesList5 = calendarEstimatesService.findAllByTeacherAndGroupNameAndItemNameAndMonthAndStudent(author, semesterAssessment.getGroupName(), semesterAssessment.getItemName(), "Июнь", semesterAssessment.getStudent());
                calendarEstimatesArrayList.add(calendarEstimatesList.get(0));
                calendarEstimatesArrayList.add(calendarEstimatesList2.get(0));
                calendarEstimatesArrayList.add(calendarEstimatesList3.get(0));
                calendarEstimatesArrayList.add(calendarEstimatesList4.get(0));
                calendarEstimatesArrayList.add(calendarEstimatesList5.get(0));
            }

            for (CalendarEstimates calendarEstimates : calendarEstimatesArrayList) {
                String str = calendarEstimates.getResult();
                if (str != null) {
                    int tempResult = Integer.parseInt(calendarEstimates.getResult());
                    if (tempResult != 0) {
                        count++;
                        sum = sum + tempResult;
                    }
                }
            }
            if (creditWork != -1) {
                int averageMouth = sum / count;
                semesterAssessment.setMonthlyEstimate(String.valueOf(averageMouth));
                double temp60 = (averageMouth * 0.60);
                double temp40 = (creditWork * 0.40);
                result = (int) (temp40 + temp60);
            }

            semesterAssessment.setSemesterResult(String.valueOf(result));
            semesterAssessmentService.saveSemesterAssessment(semesterAssessment);
        } catch (Exception e) {
            List<People> peopleList = peopleService.findAllByUsername(author);
            model.addAttribute("people", peopleList.get(0));
            model.addAttribute("semesterAssessment", semesterAssessment);
            model.addAttribute("errors", "Вы ввели не в верном формате. В ведите только цифры от 0 до 100");
            return "enquiry_update_assessments";
        }
        return "redirect:/enquiry-tm";
    }
}