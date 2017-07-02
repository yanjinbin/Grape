~~~java
        package annotation;
        //自定义注解
        @Retention(Retention.RUNTIME)
        @Target(Element.TYPE)
        public @interface Assignment{
            String assignee();
            int effort();
        }


        public class AssignmentApf implements AnnotationProcessorFactory{
            public AnnotationProcessor getProcessorFor(Set<AnnotationTypeDeclaration> atds, AnnotationProcessorEnvironment env){
                if(atds.isEmpty()) return AnnotationProcessor.NO_OP;
                return new AssignmentAp(env);
            }

            public Collection<String> supportedAnnotationTypes(){
                return Collections.unmodifiableList(Arrays.asList("annotation.Assignment"))
            }
            //用来表示所支持的附加选项。在运行apt命令行工具的时候，可以通过-A来传递额外的参数给注解处理器，如-Averbose=true。当工厂通过 supportedOptions方法声明了所能识别的附加选项之后，注解处理器就可以在运行时刻通过AnnotationProcessorEnvironment的getOptions方法获取到选项的实际值。
            public Collection<String> suppoitedOptions(){//用来表示所支持的附加选项
                return Collections.emptySet();
            }
        }


        public class AssignmentAp implements AnnotationProcessor{
            private AnnotationProcessorEnvironment env;

            private AnnotationTypeDeclaration assignmentTypeDeclaration;

            public AssignmentAp(AnnotationProcessorEnvironment env){
                this.env = env;
                assignmentDeclaration = (AnnotationTypeDeclaration)env.getTypeDeclaration("annotation.Assignment")
            }

            public void process(){
                Collection<Declaration> declarations = env.getDeclarationsAnnotatedWith(assignmentTypeDeclaration);
                for(Declaration declaration: declarations){
                    processAssignmentAnnotations(Declaration declaration);
                }
            }

            private void processAssignmentAnnotations(Declaration declaration){
                Collection<AnnotationMirror> annotationMirrors = declaration.getAnnotationMirrors();
                for(AnnotationMirror mirror : annotationMirrors){
                    if(mirror.getAnnotationType().getDeclaration().equals(assignmentTypeDeclaration)){
                        Map<AnnotationTypeDeclaration,AnnotatioValue> values = mirror.getElementValues();
                        String assignee =(String) getAnnotationValue(value,"assignee")//获取注解的值
                    }
                }
            }

            private Object getAnnotationValue(Map<? extends ExecutableElement, ? extends AnnotationValue> values, String annotationFiledName) {
                for (Entry<? extends ExecutableElement, ? extends AnnotationValue> entry : values.entrySet()) {
                    if (entry.getKey().getSimpleName().contentEquals(annotationFiledName)) {
                        return entry.getValue().getValue();
                    }
                }
                return null;
            }

        }





//-----------------------------------------------------------------------------------------------------------------





        @SupportedSourceVersion(SourceVersion.RELEASE_6)
        @supportedAnnotationTypes("annotation.Assginment")
        public class  AssignmentProcess extends AbstractProcessor{
            private TypeElement  assignElement;
            public synchronized void init(ProcessEnvironment processIngEnv){
                super.init(processIngEnv);
                Element elment = processIngEnv.getElementUtils();
                assignElement = elementUtils.getTypeElement("annotation.Assignment");

            }

            public boolean process(Set<? extends TypeElement> annotations,RoundEnvironment roundEnv){
                Set< ? extends Element >  elementSet = roundEnv.getElementsAnnotatedWith(assignElement);
                for(Element element:elementSet){
                    processAssignment(element);
                }
            }


            private void processAssignment(Element element){
                List< ? extends AnnotationMirror > annotations = element.getAnnotationMirrors();
                for(AnnotationMirror mirror:annotations){
                    if (mirror.getAnnotationType().asElement().equals(assignElement)) {
                      Map< ? extends ExecutableElement, ? extends AnnotationValue> values = mirror.getElementValues();
                      String assignee = (String)getAnnotationValue(values,"assignee");//获取注解值
                    }
                }


            }


        }


~~~

>define an annotation

>dev  an AnnotationProcessor

>implements reflect and dynamic proxy