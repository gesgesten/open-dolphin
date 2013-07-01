/*
 * Copyright 2012-2013 Canoo Engineering AG.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.opendolphin.core.server.action

import org.opendolphin.core.PresentationModel
import org.opendolphin.core.comm.DeletedAllPresentationModelsOfTypeNotification
import org.opendolphin.core.server.comm.ActionRegistry

class DeletedAllPresentationModelsOfTypeAction extends DolphinServerAction {

    void registerIn(ActionRegistry registry) {
        registry.register(DeletedAllPresentationModelsOfTypeNotification) { DeletedAllPresentationModelsOfTypeNotification command, response ->
            List models = new LinkedList( serverDolphin.modelStore.findAllPresentationModelsByType(command.pmType))
            for (PresentationModel model in models ){
                serverDolphin.modelStore.remove(model)
            }
        }
    }
}
