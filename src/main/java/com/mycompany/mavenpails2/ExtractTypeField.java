/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenpails2;

import cascading.flow.FlowProcess;
import cascading.operation.FunctionCall;
import cascading.tuple.Tuple;
import cascalog.CascalogFunction;

/**
 *
 * @author francisco
 */
public class ExtractTypeField extends CascalogFunction {
    @Override
  public void operate(FlowProcess process, FunctionCall call){
      Data data = (Data) call.getArguments().getObject(0);
      SensorPropertyValue spv = data.getDataunit().getSensor_property().getProperty();
     
      if(spv.getSetField() == SensorPropertyValue._Fields.TIPO){
          call.getOutputCollector().add(new Tuple(
                  data.getDataunit().getSensor_property().getId().getSensor_id(),
                  spv.getTipo().name(),
                  data.getPedigree().getTrue_as_of_secs()));
                  
        }
    }
  }
