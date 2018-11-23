package tzl.com.compiler.processor;

import com.google.auto.service.AutoService;
import com.squareup.javapoet.JavaFile;
import com.squareup.javapoet.MethodSpec;
import com.squareup.javapoet.TypeSpec;

import java.io.IOException;
import java.util.Collections;
import java.util.Set;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.RoundEnvironment;
import javax.lang.model.element.Modifier;
import javax.lang.model.element.TypeElement;

import tzl.com.annotation.Test;

@AutoService(Process.class)
public class TestProcessor extends AbstractProcessor {


    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        // javaPoet :https://blog.csdn.net/XSF50717/article/details/54318891
        //APT、annotationProcessor、android-apt、Provided： https://blog.csdn.net/xx326664162/article/details/68490059
        //http://hannesdorfmann.com/annotation-processing/annotationprocessing101


        //构造 字符串常量 --- FieldSpec
//        FieldSpec str = FieldSpec.builder(String.class, "str", Modifier.PRIVATE, Modifier.STATIC)
//                .build();

        //构造 main 方法 --- MethodSpec
//        MethodSpec main = MethodSpec.methodBuilder("main")
//                .addModifiers(Modifier.PUBLIC, Modifier.STATIC)
//                .returns(TypeName.VOID)
//                .addParameter(String[].class, "args")
//                .addStatement("$T.out.print($S)", System.class, "hello world")
//                .build();
//
//        //构造 类文件  ----TypeSpec
//        TypeSpec helloworld = TypeSpec.classBuilder("HelloWorld")
//                .addModifiers(Modifier.PUBLIC, Modifier.FINAL)
//                .addMethod(main)
//                .build();
//
//        //生成文件 --- JavaFile
//        JavaFile javaFile = JavaFile.builder("com.tzl.hello", helloworld)
//                .build();
//
//        try {
//            javaFile.writeTo(processingEnv.getFiler());
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return false;
        MethodSpec main = MethodSpec.methodBuilder("main")
                .addModifiers(Modifier.PUBLIC, Modifier.STATIC)
                .returns(void.class)
                .addParameter(String[].class, "args")
                .addStatement("$T.out.println($S)", System.class, "Hello, JavaPoet!")
                .build();
        TypeSpec helloWorld = TypeSpec.classBuilder("HelloWorld")
                .addModifiers(Modifier.PUBLIC, Modifier.FINAL)
                .addMethod(main)
                .build();
        JavaFile javaFile = JavaFile.builder("com.example.helloworld", helloWorld)
                .build();
        try {
            javaFile.writeTo(processingEnv.getFiler());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }


    @Override
    public Set<String> getSupportedAnnotationTypes() {
        //对应注解
        return Collections.singleton(Test.class.getCanonicalName());
    }




}
