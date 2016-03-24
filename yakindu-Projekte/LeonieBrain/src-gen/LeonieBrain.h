
#ifndef LEONIEBRAIN_H_
#define LEONIEBRAIN_H_

#include "sc_types.h"
#include "StatemachineInterface.h"
#include "TimedStatemachineInterface.h"

/*! \file Header of the state machine 'LeonieBrain'.
*/

class LeonieBrain : public TimedStatemachineInterface, public StatemachineInterface {
	
	public:
		
		LeonieBrain();
		
		~LeonieBrain();
		
		/*! Enumeration of all states */ 
		typedef enum {
			main_region_Init,
			main_region_FaceDataInterpretation,
			main_region_FaceDataInterpretation__region0_PersonKnown,
			main_region_FaceDataInterpretation__region0_PersonUnknown,
			main_region_TurnToNoise,
			main_region_Idle,
			main_region_MoveToPerson,
			main_region_SearchForChar,
			main_region_SearchForChar__region0_Standing,
			main_region_SearchForChar__region0_Walking,
			LeonieBrain_last_state
		} LeonieBrainStates;
		
		//! Inner class for AciPerson interface scope.
		class SCI_AciPerson {
			
			public:
				/*! Gets the value of the variable 'name' that is defined in the interface scope 'AciPerson'. */ 
				sc_string get_name();
				
				/*! Sets the value of the variable 'name' that is defined in the interface scope 'AciPerson'. */ 
				void set_name(sc_string value);
				
				/*! Gets the value of the variable 'confidence' that is defined in the interface scope 'AciPerson'. */ 
				sc_integer get_confidence();
				
				/*! Sets the value of the variable 'confidence' that is defined in the interface scope 'AciPerson'. */ 
				void set_confidence(sc_integer value);
				
				/*! Gets the value of the variable 'age' that is defined in the interface scope 'AciPerson'. */ 
				sc_integer get_age();
				
				/*! Sets the value of the variable 'age' that is defined in the interface scope 'AciPerson'. */ 
				void set_age(sc_integer value);
				
				/*! Gets the value of the variable 'gender' that is defined in the interface scope 'AciPerson'. */ 
				sc_boolean get_gender();
				
				/*! Sets the value of the variable 'gender' that is defined in the interface scope 'AciPerson'. */ 
				void set_gender(sc_boolean value);
				
				/*! Gets the value of the variable 'ethnicty' that is defined in the interface scope 'AciPerson'. */ 
				sc_integer get_ethnicty();
				
				/*! Sets the value of the variable 'ethnicty' that is defined in the interface scope 'AciPerson'. */ 
				void set_ethnicty(sc_integer value);
				
				/*! Gets the value of the variable 'glasses' that is defined in the interface scope 'AciPerson'. */ 
				sc_boolean get_glasses();
				
				/*! Sets the value of the variable 'glasses' that is defined in the interface scope 'AciPerson'. */ 
				void set_glasses(sc_boolean value);
				
				/*! Gets the value of the variable 'attractiveness' that is defined in the interface scope 'AciPerson'. */ 
				sc_integer get_attractiveness();
				
				/*! Sets the value of the variable 'attractiveness' that is defined in the interface scope 'AciPerson'. */ 
				void set_attractiveness(sc_integer value);
				
				/*! Gets the value of the variable 'speaking' that is defined in the interface scope 'AciPerson'. */ 
				sc_boolean get_speaking();
				
				/*! Sets the value of the variable 'speaking' that is defined in the interface scope 'AciPerson'. */ 
				void set_speaking(sc_boolean value);
				
				/*! Gets the value of the variable 'emotions' that is defined in the interface scope 'AciPerson'. */ 
				sc_string get_emotions();
				
				/*! Sets the value of the variable 'emotions' that is defined in the interface scope 'AciPerson'. */ 
				void set_emotions(sc_string value);
				
				
			private:
				friend class LeonieBrain;
				sc_string name;
				sc_integer confidence;
				sc_integer age;
				sc_boolean gender;
				sc_integer ethnicty;
				sc_boolean glasses;
				sc_integer attractiveness;
				sc_boolean speaking;
				sc_string emotions;
		};
				
		
		/*! Returns an instance of the interface class 'SCI_AciPerson'. */
		SCI_AciPerson* getSCI_AciPerson();
		
		//! Inner class for Aci interface scope.
		class SCI_Aci {
			
			public:
				/*! Gets the value of the variable 'onOffPTU' that is defined in the interface scope 'Aci'. */ 
				sc_boolean get_onOffPTU();
				
				/*! Sets the value of the variable 'onOffPTU' that is defined in the interface scope 'Aci'. */ 
				void set_onOffPTU(sc_boolean value);
				
				/*! Gets the value of the variable 'countFoundFaces' that is defined in the interface scope 'Aci'. */ 
				sc_integer get_countFoundFaces();
				
				/*! Sets the value of the variable 'countFoundFaces' that is defined in the interface scope 'Aci'. */ 
				void set_countFoundFaces(sc_integer value);
				
				
			private:
				friend class LeonieBrain;
				sc_boolean onOffPTU;
				sc_integer countFoundFaces;
		};
				
		
		/*! Returns an instance of the interface class 'SCI_Aci'. */
		SCI_Aci* getSCI_Aci();
		
		//! Inner class for Kinect interface scope.
		class SCI_Kinect {
			
			public:
				/*! Gets the value of the variable 'geste' that is defined in the interface scope 'Kinect'. */ 
				sc_string get_geste();
				
				/*! Sets the value of the variable 'geste' that is defined in the interface scope 'Kinect'. */ 
				void set_geste(sc_string value);
				
				
			private:
				friend class LeonieBrain;
				sc_string geste;
		};
				
		
		/*! Returns an instance of the interface class 'SCI_Kinect'. */
		SCI_Kinect* getSCI_Kinect();
		
		//! Inner class for LeapMotion interface scope.
		class SCI_LeapMotion {
			
			public:
				/*! Gets the value of the variable 'geste' that is defined in the interface scope 'LeapMotion'. */ 
				sc_string get_geste();
				
				/*! Sets the value of the variable 'geste' that is defined in the interface scope 'LeapMotion'. */ 
				void set_geste(sc_string value);
				
				
			private:
				friend class LeonieBrain;
				sc_string geste;
		};
				
		
		/*! Returns an instance of the interface class 'SCI_LeapMotion'. */
		SCI_LeapMotion* getSCI_LeapMotion();
		
		//! Inner class for ScitosRemoteControl interface scope.
		class SCI_ScitosRemoteControl {
			
			public:
				/*! Gets the value of the variable 'emergencyStop' that is defined in the interface scope 'ScitosRemoteControl'. */ 
				sc_boolean get_emergencyStop();
				
				/*! Sets the value of the variable 'emergencyStop' that is defined in the interface scope 'ScitosRemoteControl'. */ 
				void set_emergencyStop(sc_boolean value);
				
				
			private:
				friend class LeonieBrain;
				sc_boolean emergencyStop;
		};
				
		
		/*! Returns an instance of the interface class 'SCI_ScitosRemoteControl'. */
		SCI_ScitosRemoteControl* getSCI_ScitosRemoteControl();
		
		//! Inner class for openDail interface scope.
		class SCI_OpenDail {
			
			public:
				/*! Gets the value of the variable 'speakerMsg' that is defined in the interface scope 'openDail'. */ 
				sc_string get_speakerMsg();
				
				/*! Sets the value of the variable 'speakerMsg' that is defined in the interface scope 'openDail'. */ 
				void set_speakerMsg(sc_string value);
				
				/*! Gets the value of the variable 'leonieMsg' that is defined in the interface scope 'openDail'. */ 
				sc_string get_leonieMsg();
				
				/*! Sets the value of the variable 'leonieMsg' that is defined in the interface scope 'openDail'. */ 
				void set_leonieMsg(sc_string value);
				
				
			private:
				friend class LeonieBrain;
				sc_string speakerMsg;
				sc_string leonieMsg;
		};
				
		
		/*! Returns an instance of the interface class 'SCI_OpenDail'. */
		SCI_OpenDail* getSCI_OpenDail();
		
		//! Inner class for Mira interface scope.
		class SCI_Mira {
			
			public:
				/*! Gets the value of the variable 'randMove' that is defined in the interface scope 'Mira'. */ 
				sc_boolean get_randMove();
				
				/*! Sets the value of the variable 'randMove' that is defined in the interface scope 'Mira'. */ 
				void set_randMove(sc_boolean value);
				
				
			private:
				friend class LeonieBrain;
				sc_boolean randMove;
		};
				
		
		/*! Returns an instance of the interface class 'SCI_Mira'. */
		SCI_Mira* getSCI_Mira();
		
		//! Inner class for FaceAnimation interface scope.
		class SCI_FaceAnimation {
			
			public:
				/*! Gets the value of the variable 'emotion' that is defined in the interface scope 'FaceAnimation'. */ 
				sc_string get_emotion();
				
				/*! Sets the value of the variable 'emotion' that is defined in the interface scope 'FaceAnimation'. */ 
				void set_emotion(sc_string value);
				
				
			private:
				friend class LeonieBrain;
				sc_string emotion;
		};
				
		
		/*! Returns an instance of the interface class 'SCI_FaceAnimation'. */
		SCI_FaceAnimation* getSCI_FaceAnimation();
		
		
		
		void init();
		
		void enter();
		
		void exit();
		
		void runCycle();
		
		/*!
		* Checks if the statemachine is active (until 2.4.1 this method was used for states).
		* A statemachine is active if it was entered. It is inactive if it has not been entered at all or if it was exited.
		*/
		sc_boolean isActive();
		
		
		/*!
		* Checks if all active states are final. 
		* If there are no active states then the statemachine is considered as inactive and this method returns false.
		*/
		sc_boolean isFinal();
		
		void setTimer(TimerInterface* timer);
		
		TimerInterface* getTimer();
		
		void raiseTimeEvent(sc_eventid event);
		
		/*! Checks if the specified state is active (until 2.4.1 the used method for states was calles isActive()). */
		sc_boolean isStateActive(LeonieBrainStates state);
	
	private:
	
		//! Inner class for internal interface scope.
		class InternalSCI {
			
			public:
				/*! Raises the in event 'start' that is defined in the internal scope. */ 
				void raise_start();
				
				/*! Checks if the out event 'start' that is defined in the internal scope has been raised. */ 
				sc_boolean isRaised_start();
				
				/*! Raises the in event 'faceFound' that is defined in the internal scope. */ 
				void raise_faceFound();
				
				/*! Checks if the out event 'faceFound' that is defined in the internal scope has been raised. */ 
				sc_boolean isRaised_faceFound();
				
				/*! Raises the in event 'textMsg' that is defined in the internal scope. */ 
				void raise_textMsg();
				
				/*! Checks if the out event 'textMsg' that is defined in the internal scope has been raised. */ 
				sc_boolean isRaised_textMsg();
				
				/*! Gets the value of the variable 't' that is defined in the internal scope. */ 
				sc_integer get_t();
				
				/*! Sets the value of the variable 't' that is defined in the internal scope. */ 
				void set_t(sc_integer value);
				
				
			private:
				friend class LeonieBrain;
				sc_boolean start_raised;
				sc_boolean faceFound_raised;
				sc_boolean textMsg_raised;
				sc_integer t;
		};
	
		//! the maximum number of orthogonal states defines the dimension of the state configuration vector.
		static const sc_integer maxOrthogonalStates = 1;
		
		TimerInterface* timer;
		sc_boolean timeEvents[2];
		
		LeonieBrainStates stateConfVector[maxOrthogonalStates];
		
		sc_ushort stateConfVectorPosition;
		
		SCI_AciPerson ifaceAciPerson;
		SCI_Aci ifaceAci;
		SCI_Kinect ifaceKinect;
		SCI_LeapMotion ifaceLeapMotion;
		SCI_ScitosRemoteControl ifaceScitosRemoteControl;
		SCI_OpenDail ifaceOpenDail;
		SCI_Mira ifaceMira;
		SCI_FaceAnimation ifaceFaceAnimation;
		InternalSCI ifaceInternalSCI;
		
		// prototypes of all internal functions
		
		sc_boolean check_main_region_Init_tr0_tr0();
		sc_boolean check_main_region_TurnToNoise_tr0_tr0();
		sc_boolean check_main_region_MoveToPerson_tr0_tr0();
		sc_boolean check_main_region_SearchForChar__region0_Standing_tr0_tr0();
		sc_boolean check_main_region_SearchForChar__region0_Standing_tr1_tr1();
		sc_boolean check_main_region_SearchForChar__region0_Standing_tr2_tr2();
		sc_boolean check_main_region_SearchForChar__region0_Walking_tr0_tr0();
		sc_boolean check_main_region_SearchForChar__region0_Walking_tr1_tr1();
		sc_boolean check_main_region_SearchForChar__region0_Walking_tr2_tr2();
		void effect_main_region_Init_tr0();
		void effect_main_region_TurnToNoise_tr0();
		void effect_main_region_MoveToPerson_tr0();
		void effect_main_region_SearchForChar__region0_Standing_tr0();
		void effect_main_region_SearchForChar__region0_Standing_tr1();
		void effect_main_region_SearchForChar__region0_Standing_tr2();
		void effect_main_region_SearchForChar__region0_Walking_tr0();
		void effect_main_region_SearchForChar__region0_Walking_tr1();
		void effect_main_region_SearchForChar__region0_Walking_tr2();
		void enact_main_region_SearchForChar__region0_Standing();
		void enact_main_region_SearchForChar__region0_Walking();
		void exact_main_region_SearchForChar__region0_Standing();
		void exact_main_region_SearchForChar__region0_Walking();
		void enseq_main_region_Init_default();
		void enseq_main_region_FaceDataInterpretation_default();
		void enseq_main_region_FaceDataInterpretation__region0_PersonKnown_default();
		void enseq_main_region_FaceDataInterpretation__region0_PersonUnknown_default();
		void enseq_main_region_TurnToNoise_default();
		void enseq_main_region_MoveToPerson_default();
		void enseq_main_region_SearchForChar__region0_Standing_default();
		void enseq_main_region_SearchForChar__region0_Walking_default();
		void enseq_main_region_default();
		void enseq_main_region_FaceDataInterpretation__region0_default();
		void exseq_main_region_Init();
		void exseq_main_region_FaceDataInterpretation__region0_PersonKnown();
		void exseq_main_region_FaceDataInterpretation__region0_PersonUnknown();
		void exseq_main_region_TurnToNoise();
		void exseq_main_region_Idle();
		void exseq_main_region_MoveToPerson();
		void exseq_main_region_SearchForChar();
		void exseq_main_region_SearchForChar__region0_Standing();
		void exseq_main_region_SearchForChar__region0_Walking();
		void exseq_main_region();
		void exseq_main_region_FaceDataInterpretation__region0();
		void exseq_main_region_SearchForChar__region0();
		void react_main_region_Init();
		void react_main_region_FaceDataInterpretation__region0_PersonKnown();
		void react_main_region_FaceDataInterpretation__region0_PersonUnknown();
		void react_main_region_TurnToNoise();
		void react_main_region_Idle();
		void react_main_region_MoveToPerson();
		void react_main_region_SearchForChar__region0_Standing();
		void react_main_region_SearchForChar__region0_Walking();
		void react_main_region__entry_Default();
		void react_main_region_FaceDataInterpretation__region0__entry_Default();
		void react_main_region_SearchForChar__region0__sync0();
		void clearInEvents();
		void clearOutEvents();
		
};
#endif /* LEONIEBRAIN_H_ */
