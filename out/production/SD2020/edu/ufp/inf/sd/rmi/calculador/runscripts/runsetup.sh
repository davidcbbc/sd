#REM ************************************************************************************
#REM Description: run HelloWorldSetup
#REM Author: Rui S. Moreira
#REM Date: 20/02/2014
#REM ************************************************************************************
#REM Script usage: runsetup <role> (where role should be: server / client)
#source ./setenv.sh
source ./setenv.sh server

cd ${ABSPATH2CLASSES}
#clear
#pwd
#java -cp ${CLASSPATH} \
#     #Property defining the security policy file for the Setup program
#     -Djava.security.policy=setup.policy \
#
#     #Property defining the root directory for the implementation's classes
#     -Djava.rmi.server.codebase=${SERVER_CODEBASE} \
#
#     #Property defining the root directory for the Setup program's classes
#     -Dexamples.activation.setup.codebase=${SERVER_CODEBASE} \
#
#     #Property defining the root directory for the implementation's classes
#     -Dexamples.activation.impl.codebase=${SERVER_CODEBASE} \
#
#     #Property defining the name of the service (this property is used inside main() for registry rebind)
#     -Dexamples.activation.name=${SERVICE_NAME} \
#
#     #Property defining a file containing a persistent object
#     [-Dexamples.activation.file=filename] \
#
#     #Property defining the security policy file for the activation group
#     [-Dexamples.activation.policy=group.policy] \
#     examples.activation.Setup ${SERVER_ACTIVATABLE_CLASS}
java -cp ${CLASSPATH} \
     -Djava.security.policy=${SERVER_SECURITY_POLICY} \
     -Djava.rmi.server.codebase=${SERVER_CODEBASE} \
     -D${JAVAPACKAGE}.activation.setup.codebase=${SERVER_CODEBASE} \
     -D${JAVAPACKAGE}.activation.impl.codebase=${SERVER_CODEBASE} \
     -D${JAVAPACKAGE}.activation.servicename=${SERVICE_NAME} \
     -D${JAVAPACKAGE}.activation.file=${SERVANT_PERSISTENT_STATE_FILENAME} \
     -D${JAVAPACKAGE}.activation.policy=${GROUP_SECURITY_POLICY} \
     ${JAVAPACKAGEROLE}.${SERVER_CLASS_PREFIX}${SETUP_CLASS_POSTFIX} ${REGISTRY_HOST} ${REGISTRY_PORT} ${SERVANT_ACTIVATABLE_IMPL_CLASS}

cd ${ABSPATH2SRC}/${JAVASCRIPTSPATH}
#pwd