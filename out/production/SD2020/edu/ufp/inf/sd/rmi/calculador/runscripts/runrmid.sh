#REM ************************************************************************************
#REM Description: make file for RMI stub generation
#REM Author: Rui S. Moreira
#REM Date: 20/02/2014
#REM ************************************************************************************
#REM Script usage: runsetup <role> (where role should be: server / client)
#source ./setenv.sh
source ./setenv.sh server

#REM The rmid command starts the activation system daemon and an internal registry on default port 1098
#REM and binds an ActivationSystem to name java.rmi.activation.ActivationSystem in internal registry.
#REM rmid -J-Dsun.rmi.rmid.maxstartgroup=10 -J-Dsun.rmi.server.exceptionTrace=true -J-Dsun.rmi.server.activation.debugExec=true -J-Dsun.rmi.log.debug=true -J-Djava.rmi.server.logCalls=true -J-Djava.rmi.server.hostname=%MarsupilamiIP% -J-Djava.security.policy=%POLICY% -J-D-Djava.rmi.server.codebase=%CODEBASE%
#REM rmid -J-Dsun.rmi.rmid.maxstartgroup=10 -J-Dsun.rmi.server.exceptionTrace=true -J-Dsun.rmi.server.activation.debugExec=true -J-Dsun.rmi.log.debug=true -J-Djava.rmi.server.logCalls=true -J-Djava.rmi.server.hostname=%ZezinhoIP% -J-Djava.security.policy=%POLICY% -J-D-Djava.rmi.server.codebase=%CODEBASE%
#REM rmid -J-Djava.security.policy=rmid.policy -port 1099 &
rmid -J-Djava.security.policy=${RMID_SECURITY_POLICY} \
     -J-Djava.rmi.server.codebase=${SERVER_CODEBASE} \
     -J-D${JAVAPACKAGE}.activation.policy=${GROUP_SECURITY_POLICY}
#REM cd ${ABSPATH2CLASSES}
#REM cls
