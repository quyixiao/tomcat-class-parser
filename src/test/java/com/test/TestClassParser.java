package com.test;

import org.apache.tomcat.util.bcel.classfile.*;

import java.io.File;
import java.io.FileInputStream;
import java.util.List;

public class TestClassParser {


    public static void main(String[] args)  throws Exception{

        FileInputStream fis =   new FileInputStream(new File("/Users/quyixiao/github/tomcat-class-parser/target/test-classes/com/test/TestAnnotation.class"));;

        ClassParser parser = new ClassParser(fis);
        JavaClass clazz = parser.parse();

        AnnotationEntry[] annotationsEntries = clazz.getAnnotationEntries();
        if (annotationsEntries != null) {
            String className = clazz.getClassName();
            for (AnnotationEntry ae : annotationsEntries) {
                String type = ae.getAnnotationType();
                System.out.println("annotaionType = " + type);
                List<ElementValuePair> elementValuePairs = ae.getElementValuePairs();
                for(ElementValuePair elementValuePair : elementValuePairs){
                    System.out.println("====================");
                    System.out.println(elementValuePair.getNameString());
                    ElementValue elementValue = elementValuePair.getValue();
                    System.out.println(elementValue.stringifyValue());

                }
            }
        }

    }
}
