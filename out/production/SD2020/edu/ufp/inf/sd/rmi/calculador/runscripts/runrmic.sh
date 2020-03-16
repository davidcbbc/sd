#@REM ************************************************************************************
#@REM Description: make file for RMI stub generation
#@REM Author: Rui S. Moreira
#@REM Date: 20/02/2014
#@REM ************************************************************************************
#@REM source ./setenv.sh
source ./setenv.sh server
#rmic -d ${ABSPATH2CLASSES} -classpath ${CLASSPATH} ${JAVAPACKAGE}.${SERVER_CLASS_PREFIX}Impl
rmic -d ${ABSPATH2CLASSES} -classpath ${CLASSPATH} ${JAVAPACKAGEROLE}.${SERVER_CLASS_PREFIX}${SERVANT_IMPL_CLASS_POSTFIX}
#rmic -d ${ABSPATH2CLASSES} -classpath ${CLASSPATH} ${JAVAPACKAGE}.${SERVER_CLASS_PREFIX}Activatable
rmic -d ${ABSPATH2CLASSES} -classpath ${CLASSPATH} ${JAVAPACKAGEROLE}.${SERVER_CLASS_PREFIX}${SERVANT_ACTIVATABLE_IMPL_CLASS_POSTFIX}