// <autogenerated>
//   This file was generated by dddappp code generator.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

package org.dddappp.suiinscription.domain.inscription;

import java.util.Map;
import java.util.List;
import org.dddml.support.criterion.Criterion;
import java.math.BigInteger;
import java.util.Date;
import org.dddappp.suiinscription.domain.*;

public interface InscriptionStateQueryRepository {
    InscriptionState get(String id);

    Iterable<InscriptionState> getAll(Integer firstResult, Integer maxResults);
    
    Iterable<InscriptionState> get(Iterable<Map.Entry<String, Object>> filter, List<String> orders, Integer firstResult, Integer maxResults);

    Iterable<InscriptionState> get(Criterion filter, List<String> orders, Integer firstResult, Integer maxResults);

    InscriptionState getFirst(Iterable<Map.Entry<String, Object>> filter, List<String> orders);

    InscriptionState getFirst(Map.Entry<String, Object> keyValue, List<String> orders);

    Iterable<InscriptionState> getByProperty(String propertyName, Object propertyValue, List<String> orders, Integer firstResult, Integer maxResults);

    long getCount(Iterable<Map.Entry<String, Object>> filter);

    long getCount(Criterion filter);

}
