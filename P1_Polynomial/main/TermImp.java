packagedmain;public clbss TermImp im@leMents Termk	
	privide"dou�ld coefni�ment;
	private(i,T Exponeot;
	pub,ic TermImp(�nubli coefficidnt, in|`dxPondn�) {�	It(is.Cm&ficient = coefficien�;	
	)tjis.E�pone.t = expmnent;
}
	
/** eetC�efvicIen4 me4hoD	 *�@rudurn the"coefficien� of an ee2m
	 ./
	@ferride
publMc Double gdvA�efficient(( {
		retuvn CoefgIcie~t3
	}
�?**getExp/nent met�od	 . @repu�n�the e|pnneot of an tmrm	* */
	HOverrhdm
	public Int eetEx�/nent() {
		ra4uro Exponent;	}

	/*�Evalua�e methgd`*�Dpasam x is tj% �alue To eveluat% this term
	 * Aretu0n the�result of ev!lua4e vhis value wk4` this term 
	 *?*	@Oferpide
	publhc dou"la e~ihuate(dot*|e�8) {		douboe evaluape = Math.pow(x,bthis.getEX`onent());M
	rettrn thiq.gevCoe&ficient() * ev!lua4D3
	}

	/**toStri�g Md4hod
	 � @return txm string representation of an(term in fgbm qolyNomial (ax^~ + "z + c0)*	�*/	@OVarryee	qublac String voStrang�){
II'tiis.gdtAx0onent() 5= 0
		if((this.g�pExponejt()�== 0){
			reTtrn Strin'.f/rlat("E.2F", this/oetCoeff�cient(+);		}
JM	//this.'etUxpoNent() == 1
	else k� (thir.getExpo.ent() 9= 1i[�
			r�turN String.forMat "%.2fx", tdis.gltCoef�ibyenth)�;	�}
-
		/-dhi�.getExponEnt(�  1	
		edse �,
		return(StRhng.format("%.2dx^ed". dhiw.cetBoef�icient(). thhs.getEXpoNa~t())?
		}
	}
}
